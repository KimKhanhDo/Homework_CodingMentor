package coding.mentor.service;

import java.util.ArrayList;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.data.User;
import coding.mentor.db.Database;

public class UserService {

	public void registerNewUser(String id, String password, String name) {
		// check if id exits on DB or NOT??
		for ( int i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(id) && 
					Database.USERS_DB.get(i).getId().equals(password)) {
				System.out.println("This Account Already Exists. Please register a new one");
				return;
			}
		}
		// Create and add the new user to the USERS_DB
		// new Object User with user's input
		User user = new User(id, password, name);
		Database.USERS_DB.add(user);
		System.out.println("Register successfully");
	}

	public User login(String id, String password) {
		for (User user : Database.USERS_DB) {
			if(user.getId().equals(id) && user.getPassword().equals(password)) {
				System.out.println("Login Successfully");
				return user;
			} 
			else {
				int failedCount = user.getFailedCount() + 1;
				user.setFailedCount(failedCount);
				System.out.println("Invalid Account!!!");

				if (failedCount > 3) {
					System.out.println("You account is locked");
				}
			}
			return null; // Return null -> failed login
		}
		  System.out.println("Your Account Does Not Exist. Please Register");
		    return null; // Return null -> failed login
	}
	

	public void showRegisteredCourseToUser(User user) {
	    ArrayList<Course> registeredCourses = user.getRegisteredCourses();

	    if (registeredCourses == null || registeredCourses.isEmpty()) {
	        System.out.println("No course is registered");
	    } else {
	        System.out.println("Registered Courses:");
	        for (Course course : registeredCourses) {
	            System.out.println(course.getName());
	        }
	    }
	}
		
	
	public void registerNewCourse(int courseID, User user) {
	    ArrayList<Course> registeredCourses = user.getRegisteredCourses();

	    if (registeredCourses == null) {
	        registeredCourses = new ArrayList<>();
	        user.setRegisteredCourses(registeredCourses);
	    }

	    for (Course course : Database.COURSES_DB) {
	        if (course.getId() == courseID) {
	            registeredCourses.add(course);
	            System.out.println("Register Successfully");
	            return;
	        }
	    }

	    System.out.println("Course not found");
	}
}
