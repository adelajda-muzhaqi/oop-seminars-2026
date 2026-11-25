package university;

public class UniversityApp {

	public static void main(String[] args) {
		
		Student ada = new Student ("Ada Lovelace", 0.0, 2024);
		Student same = new Student (ada.getStudentId(), "Ada Lovelace", 2024);
		System.out.println(ada);
		System.out.println(same);
		System.out.println(ada == same);
		System.out.println(ada.equals(same));

	}
}
  