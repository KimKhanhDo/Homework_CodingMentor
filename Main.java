package coding.mentor;

import java.util.Scanner;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.data.User;
import coding.mentor.db.Database;
import coding.mentor.service.CourseService;
import coding.mentor.service.UserService;

public class Main {

	static final int LOGIN = 1;
	static final int REGISTER = 2;
	static final int REGISTER_NEW_COURSE = 1;
	static final int NO_REGISTER_COURSE = 2;
	static final int VIEW_MENTOR_INFO = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		CourseService courseService = new CourseService();
		UserService userService = new UserService();
		Database.initDB();
		User loggedInUser = null;

		int selectedOption;

		do {
			System.out.println("----- Welcome To Coding Mentor -----");
			System.out.println("1. Login");
			System.out.println("2. Register");
			selectedOption = scanner.nextInt();
			scanner.nextLine();

			switch (selectedOption) {
			case LOGIN:
				System.out.println("Enter ID: ");
				String loginId = scanner.nextLine();
				System.out.println("Enter password: ");
				String loginPassword = scanner.nextLine();

				loggedInUser = userService.login(loginId, loginPassword);

				if (loggedInUser != null) {

					int selectedCourseByUser;

					do {
						System.out.println("----------------- ");
						System.out.println("0. Show my registered courses");
						courseService.showAllCourses();

						System.out.println("Enter your option: ");
						selectedCourseByUser = scanner.nextInt();

						if (selectedCourseByUser == 0) {
							userService.showRegisteredCourseToUser(loggedInUser);
							break;
						}

						courseService.showCourseDetails(selectedCourseByUser);

						System.out.println("----- Do you want to study with us? -----");
						System.out.println("1. Register");
						System.out.println("2. NO");
						System.out.println("3. See your mentor info");
						int userOption = scanner.nextInt();

						switch (userOption) {

						case REGISTER_NEW_COURSE:
							userService.registerNewCourse(selectedCourseByUser, loggedInUser);
							break;

						case NO_REGISTER_COURSE:
							System.out.println("We hope to see you in the next course");
							break;

						case VIEW_MENTOR_INFO:
							System.out.println("Enter course ID to see detail info of your mentor: ");
							int courseID = scanner.nextInt();
							// passing an object of the Course for which you want to display mentors
							Course selectedCourse = new Course(courseID);
							courseService.showMentorByCourse(selectedCourse);
							break;

						}

					} while (selectedCourseByUser != 0);

				}
				break; // for loginUser

			case REGISTER:
				System.out.println("----- Register Form -----");
				System.out.println("Input ID: ");
				String id = scanner.nextLine();
				System.out.println("Input password: ");
				String password = scanner.nextLine();
				System.out.println("Input name: ");
				String name = scanner.nextLine();

				userService.registerNewUser(id, password, name);
			}

		} while (loggedInUser == null);

	}

}
