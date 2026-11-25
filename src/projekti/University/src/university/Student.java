package university;
import java.util.ArrayList;
import java.util.List;
import java.time.Year;
import java.util.Objects;

public class Student {

	// ATRIBUTET
	
	private final String studentId;
	private String name;
	private double gpa;
	private final int enrolmentYear;
	private static int lastIdIssued = 1000;
	private final List<Course> courses = new ArrayList<>();
	
	// KONSTRUKTORI I PARE
	
	public Student(String studentId, String name, double gpa, int enrolmentYear) {
		
		if(studentId == null || studentId.isBlank()) {
			throw new IllegalArgumentException("Id e studentit nuk mund te jete bosh.");
		}
		this.studentId = studentId;
		
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Emri i studentit nuk mund te jete bosh.");
		}
		this.name = name;
		
		if (gpa < 0.0 || gpa > 4.0) {
		    throw new IllegalArgumentException("GPA duhet te jete midis 0.0 dhe 4.0: " + gpa);
		}
		this.gpa = gpa;
		
		int currentYear = Year.now().getValue();
        if (enrolmentYear < 2000 || enrolmentYear > currentYear) {
            throw new IllegalArgumentException("Viti i regjistrimit duhet të jete midis 2000 dhe " + currentYear);
        }
        this.enrolmentYear = enrolmentYear;
	   }
	
	// KONSTRUKTORI I DYTE
	
	public Student(String studentId, String name, int enrolmentYear) {
		if(studentId == null || studentId.isBlank()) {
			throw new IllegalArgumentException("Id e studentit nuk mund te jete bosh.");
		}
		this.studentId = studentId;
		
		
		
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Emri i studentit nuk mund te jete bosh.");
		}
		this.name = name;
		
		
		
		int currentYear = Year.now().getValue();
        if (enrolmentYear < 2000 || enrolmentYear > currentYear) {
            throw new IllegalArgumentException("Viti i regjistrimit duhet të jete midis 2000 dhe " + currentYear);
        }
        this.enrolmentYear = enrolmentYear;
	}

	public Student(String name, double gpa, int enrolmentYear) {
		this(nextId(), name, gpa, enrolmentYear);
	}
	private static String nextId() {
		lastIdIssued++;
		return "S" + lastIdIssued;
	}
	  // METODAT
	
	public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Emri nuk mund të jetë bosh.");
        }
        this.name = name;
    }
	
	    public void updateGpa(double newGpa) {
		if(newGpa < 0.0 || newGpa > 4.0) {
			throw new IllegalArgumentException("Gpa duhet te jete midis 0.0 dhe 4.0.");
		}
		this.gpa = newGpa;
	   }
	
	    public String academicStanding() {
	    	if(gpa >= 2.0) {
	    		return "Good standing";
	    	} else if (gpa >= 1.5) {
	    		return "Academic probation";
	    	} else { 
	    		return "Academic warning";
	    	}
	    }
	    public int yearsEnrolled(int currentYear) {
	        if (currentYear < enrolmentYear) {
	            throw new IllegalArgumentException("Viti aktual nuk mund te jete para vitit te regjistrimit.");
	        }
	        return currentYear - enrolmentYear;
	    }
	    
	    public double getGpa() {
	        return gpa;
	    }

	    public int getEnrolmentYear() {
	        return enrolmentYear;
	    }
	    
	    public int getCourseCount() {
	        return courses.size();
	    }

	    public boolean register(Course course) {
	        if (course == null) return false;
	        if (courses.size() >= 6) return false;
	        if (courses.contains(course)) return false;
	        courses.add(course);
	        return true;
	    }

	    public boolean hasCourse(String courseCode) {
	        for (Course c : courses) {
	            if (c.getCourseCode().equals(courseCode)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public boolean drop(String courseCode) {
	        for (Course c : courses) {
	            if (c.getCourseCode().equals(courseCode)) {
	                courses.remove(c);
	                return true;
	            }
	        }
	        return false;
	    }

	    public int totalCredits() {
	        int total = 0;
	        for (Course c : courses) {
	            total += c.getCredits();
	        }
	        return total;
	    }

	    public List<Course> getCourses() {
	        return List.copyOf(courses);
	    }
	    
	    
	    
	    @Override  
	    public boolean equals(Object obj) {
	    	if(this == obj) return  true;
	    	if(!(obj instanceof Student)) return false;
	    Student std = (Student) obj;    
	    return this.studentId.equals((std.getStudentId()));
}
	    
	    @Override
	    public String toString() {
	        return name + " (ID: " + studentId + ", GPA: " + gpa + ", Statusi: " + academicStanding() + ")";
	    }
}

