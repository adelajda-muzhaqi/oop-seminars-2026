package university;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private final String departmentCode;
    private String name;
    private String head;
    private final List<Professor> professors = new ArrayList<>();

    public Department(String departmentCode, String name, String head) {
        this.departmentCode = requireText(departmentCode, "Department code");
        this.name = requireText(name, "Name");
        this.head = requireText(head, "Head");
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = requireText(name, "Name");
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = requireText(head, "Head");
    }

    /** Refuses null and a professor who is already here. */
    public boolean addProfessor(Professor professor) {
        if (professor == null || professors.contains(professor)) {
            return false;
        }
        professors.add(professor);
        return true;
    }

    public boolean removeProfessor(String employeeId) {
        for (int i = 0; i < professors.size(); i++) {
            if (professors.get(i).getEmployeeId().equals(employeeId)) {
                professors.remove(i);
                return true;
            }
        }
        return false;
    }
 // Counted, never stored: a numberOfFaculty field would go out of date
    public int facultyCount() {
        return professors.size();
    }

    // The department does not add up credits itself. It asks each professor.
    public int totalTeachingLoad() {
        int total = 0;
        for (Professor p : professors) {
            total += p.totalTeachingCredits();
        }
        return total;
    }

    public List<Professor> getProfessors() {
        return List.copyOf(professors);
    }

    private static String requireText(String value, String label) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(label + " must not be blank: \"" + value + "\"");
        }
        return value;
    }

    @Override
    public String toString() {
        return departmentCode + " " + name + " (head: " + head + ", " + facultyCount() + " professors)";
    }
}