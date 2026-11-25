package university;

public class Professor {
	
	import java.util.Objects;
    private final String employeeId; 
    private String name;
    private String specialisation;
    private int yearsOfExperience;
    private static int lastIdIssued = 2000;
    
    public Professor(String name, String specialisation, int yearsOfExperience) {
        
    	lastIdIssued++;
    	this.employeeId = "P" + lastIdIssued;
        
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Hapësira e emrit nuk mund të jetë bosh.");
        }
        this.name = name;
        
        if (specialisation == null || specialisation.isBlank()) {
            throw new IllegalArgumentException("Specializimi nuk mund të jetë bosh.");
        }
        this.specialisation = specialisation;
        
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Vitet e eksperiencës nuk mund të jene negative.");
        }
        this.yearsOfExperience = yearsOfExperience;
    }
    
    public String academicTitle() {
        if (yearsOfExperience <= 5) {
            return "Assistant Professor";
        } else if (yearsOfExperience <= 10) { 
            return "Associate Professor";
        } else {
            return "Professor";
        }
    }
    
    public boolean isExperienced() {
        return yearsOfExperience > 5;
    }
    
    public void completeAnotherYear() {
        yearsOfExperience++;
    }
   
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getSpecialisation() { return specialisation; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Professor)) return false;
        Professor other = (Professor) obj;
        return employeeId.equals(other.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
    @Override
    public String toString() {
        return "Professor [ID: " + employeeId + ", Name: " + name + 
               ", Specialisation: " + specialisation + ", Years: " + yearsOfExperience + 
               " (" + academicTitle() + ")]";
    }

