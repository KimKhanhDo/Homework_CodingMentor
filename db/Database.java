package coding.mentor.db;

import java.util.ArrayList;
import java.util.Date;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.data.User;

public class Database {
	public static ArrayList<Mentor> MENTORS_DB = new ArrayList<>();
	public static ArrayList<Course> COURSES_DB = new ArrayList<>();
	public static ArrayList<User> USERS_DB = new ArrayList<>();

//public Database() {
//	
//}

	public static void initDB() {
		// initialize Mentor DB
		// Mentor mentor = new Mentor(1, "Dung", "dung@gmail.com", "1080");
		MENTORS_DB.add(new Mentor(1, "Dung", "dung@gmail.com", "1080"));
		MENTORS_DB.add(new Mentor(2, "Jayden", "jayden@gmail.com", "1081"));
		MENTORS_DB.add(new Mentor(1, "Toni", "toni@gmail.com", "1082"));

		// initialize Course DB (3 mentors + 3 courses)
		ArrayList<Mentor> teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(0));
		COURSES_DB.add(new Course(1, "BE 1", teachingMentors, new Date(), new Date(), 3000));

		teachingMentors = new ArrayList<Mentor>(); // Create a new ArrayList for the next course
		teachingMentors.add(MENTORS_DB.get(0));
		teachingMentors.add(MENTORS_DB.get(1));
		COURSES_DB.add(new Course(2, "BE 2", teachingMentors, new Date(), new Date(), 3100));

		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(2));
		COURSES_DB.add(new Course(3, "DATA 1", teachingMentors, new Date(), new Date(), 2500));

	}
}

//Database.thisIsUtilFunctionCanBeUsedAnyWhereWithoutCreateNewObject();
