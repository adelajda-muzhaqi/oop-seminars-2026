package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    // ATRIBUTET

    private final String name;
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    // KONSTRUKTORI

    public University(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Emri i universitetit nuk mund te jete bosh: " + name);
        }
        this.name = name;
    }

    // GETTERS

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    public List<Course> getCourses() {
        return List.copyOf(courses);
    }

    // SHTIMI I STUDENTEVE DHE KURSEVE

    public Student addStudent(String name, int enrolmentYear) {
        Student student = new Student(name, enrolmentYear);
        students.add(student);
        return student;
    }

    public Course addCourse(String code, String title, int credits, String semester, int maxStudents) {
        Course course = new Course(code, title, credits, semester, maxStudents);
        courses.add(course);
        return course;
    }

    // KERKIMI (kthen null nese nuk gjendet)

    public Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    public Course findCourse(String courseCode) {
        for (Course c : courses) {
            if (c.getCourseCode().equals(courseCode)) {
                return c;
            }
        }
        return null;
    }

    // REGJISTRIMI: vetem kjo metode ndryshon te dyja anet

    public boolean enrol(String studentId, String courseCode) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);

        if (student == null || course == null) {
            return false;                       // asgje nuk ka ndryshuar
        }
        if (student.hasCourse(courseCode)) {
            return false;                       // tashme i regjistruar
        }
        if (course.isFull()) {
            return false;                       // kursi eshte plot
        }
        if (!student.register(course)) {
            return false;                       // studenti ka arritur kufirin
        }
        course.addStudent(student);             // vetem tani ndryshojne te dyja anet
        return true;
    }

    public boolean withdraw(String studentId, String courseCode) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);

        if (student == null || course == null) {
            return false;
        }
        if (!student.hasCourse(courseCode)) {
            return false;
        }
        student.drop(courseCode);
        course.removeStudent(student);
        return true;
    }

    // KONTROLLI: te dy numrat duhet te jene gjithmone te barabarta

    public int enrolmentsFromStudents() {
        int total = 0;
        for (Student s : students) {
            total += s.getCourseCount();
        }
        return total;
    }

    public int enrolmentsFromCourses() {
        int total = 0;
        for (Course c : courses) {
            total += c.getStudentCount();
        }
        return total;
    }
}