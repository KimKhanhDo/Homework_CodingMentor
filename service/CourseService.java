package coding.mentor.service;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.db.Database;

public class CourseService {

	public void showAllCourses() {
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			System.out.print((i + 1) + ". " + Database.COURSES_DB.get(i).getName());

			for (Mentor mentor : Database.COURSES_DB.get(i).getTeachingMentors()) {
				System.out.print(" - Mentor name: " + mentor.getName());
			}
			System.out.println();
		}
	}

	public void showCourseDetails(int courseID) {

		Course courseDetails = new Course(courseID);

		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			Course courseDatabase = Database.COURSES_DB.get(i);

			if (courseID == courseDatabase.getId()) {
				System.out.println("----------------------------");
				System.out.print((i + 1) + ". " + courseDatabase.getName());

				for (Mentor mentor : courseDatabase.getTeachingMentors()) {
					System.out.print(" - Mentor name: " + mentor.getName());
				}

				System.out.println();
				System.out.println(" - Begin: " + courseDatabase.getBegin());
				System.out.println(" - End: " + courseDatabase.getEnd());
				System.out.println(" - Fee: " + courseDatabase.getFee());

			}
		}
	}

	public void showMentorByCourse(Course courseID) {

		for (Course courseDatabase : Database.COURSES_DB) {
			if (courseID.getId() == courseDatabase.getId()) {
				System.out.println("********* Mentors for Course **********");
				for (Mentor mentor : courseDatabase.getTeachingMentors()) {
					System.out.println(" - Mentor ID: " + mentor.getId());
					System.out.println(" - Mentor name: " + mentor.getName());
					System.out.println(" - Mentor email: " + mentor.getEmail());
					System.out.println(" - Mentor phone: " + mentor.getPhone());
				}
				System.out.println();
			}
		}
	}

	public void showMentorByCourse2(int courseID) {
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			if (courseID == Database.COURSES_DB.get(i).getId()) {
				System.out.println("********* Mentors for Course **********");

				for (Mentor mentor : Database.COURSES_DB.get(i).getTeachingMentors()) {
					System.out.println(" - Mentor ID: " + mentor.getId());
					System.out.println(" - Mentor name: " + mentor.getName());
					System.out.println(" - Mentor email: " + mentor.getEmail());
					System.out.println(" - Mentor phone: " + mentor.getPhone());
				}
				System.out.println();
			}
		}
	}

}
