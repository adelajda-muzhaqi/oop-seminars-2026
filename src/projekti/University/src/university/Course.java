package university;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Course {
    private final String courseCode;
    private String title;
    private final int credits;
    private final String semester;
    private final int maxStudents;
    private final List<Student> students = new ArrayList<>();
    // Konstruktori 
    
    
    public Course(String courseCode, String title, int credits, String semester, int maxStudents) {
        this.courseCode = requireText(courseCode, "Course code");
        
        this.title = requireText(title, "Title");
        
        if (credits < 1 || credits > 6) {
            throw new IllegalArgumentException("Credits need to be between 1 and 6: " + credits);
        }
        this.credits = credits;
        
        this.semester = requireText(semester, "Semester");
        
        if (maxStudents < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1: " + maxStudents);
        }
        this.maxStudents = maxStudents;
    }

    public Course(String courseCode, String title, int credits, String semester) {
        this(courseCode, title, credits, semester, 30);
    }

    private static String requireText(String value, String label) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(label + " cannot be blank or null: " + value);
        }
        return value;
    }
    
    
    // Getters
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public String getSemester() {
        return semester;
    }
    
    // Setters
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank or null.");
        }
        this.title = title;
    }
    
    // Metoda e biznesit: Kthen true nëse lënda ka 3 ose më shumë kredite
    public boolean isMajorCourse() {
        return credits >= 3;
    }
    
    public int getMaxStudents() { return maxStudents; }

    public boolean isFull() {
        return students.size() >= maxStudents;
    }

    public int getStudentCount() {
        return students.size();
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        return courseCode.equals(other.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
    
    // Metoda toString për printimin e objektit
    @Override
    public String toString() {
        return courseCode + ": " + title + " (" + credits + " credits, " + semester + ")";
    }
}
