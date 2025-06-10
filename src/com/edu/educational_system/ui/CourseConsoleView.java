package com.edu.educational_system.ui;

import java.util.Scanner;

import com.edu.educational_system.controller.*;


public class CourseConsoleView {
	private final Scanner scanner = new Scanner(System.in);
	private final Controller controller;

	public CourseConsoleView(Controller controller) {
	    this.controller = controller;
	}

	public void displayMenu() {
		while (true) {
			System.out.println("\n==== Course Management Menu ====");
			System.out.println("1. Create Course");
			System.out.println("2. Register Person to Course");
			System.out.println("3. Show Special Course Info");
			System.out.println("4. Start Lesson");
			System.out.println("5. Show All Courses");
			System.out.println("6. Obfuscate Data");
			System.out.println("7. Show Average Grade");
	        System.out.println("8. Show Participants");
	        System.out.println("9. Show Staff");
	        System.out.println("10. Exit");
			System.out.print("Choose option: ");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1 -> createCourse();
			case 2 -> registerPerson();
			case 3 -> showCourseInfo();
			case 4 -> startLesson();
			case 5 -> showAllCourses();
			case 6 -> obfuscateData();
			case 7 -> showAverageGrade();
            case 8 -> showParticipants();
            case 9 -> showStaff();
            case 10 -> {
				System.out.println("Exiting.");
				return;
			}
			default -> System.out.println("Invalid option.");
			}
		}
	}

	private void createCourse() {
		System.out.print("Course name: ");
		String courseName = scanner.nextLine();
		String request = "CREATE_COURSE\n" + courseName;
		String response = controller.doAction(request);
		System.out.println(response);
	}

	private void registerPerson() {
		System.out.print("Course name: ");
		String courseName = scanner.nextLine();
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.println("Role (student, teacher, administrator): ");
		String role = scanner.nextLine().toLowerCase();

		StringBuilder request = new StringBuilder();
		request.append("REGISTER_PERSON\n").append(courseName).append("\n").append(name).append("\n").append(email)
				.append("\n").append(role).append("\n");

		switch (role) {
		case "student" -> {
			System.out.print("Group: ");
			String group = scanner.nextLine();
			System.out.print("Average grade: ");
			String grade = scanner.nextLine();
			request.append(group).append("\n").append(grade);
		}
		case "teacher" -> {
			System.out.print("Subject: ");
			String subject = scanner.nextLine();
			request.append(subject);
		}
		case "administrator" -> {
			System.out.print("Department: ");
			String dept = scanner.nextLine();
			request.append(dept);
		}
		default -> {
			System.out.println("Unknown role.");
			return;
		}
		}
		String response = controller.doAction(request.toString());
		System.out.println(response);
	}

	private void startLesson() {
		System.out.print("Course name: ");
		String courseName = scanner.nextLine();
		String request = "START_LESSON\n" + courseName;
		String response = controller.doAction(request);
		System.out.println(response);
	}

	private void showCourseInfo() {
	    System.out.print("Course name: ");
	    String courseName = scanner.nextLine();
	    String request = "SHOW_SPECIAL_COURSE_INFO\n" + courseName; 
	    String response = controller.doAction(request);
	    System.out.println(response);
	}

	private void showAllCourses() {
		String response = controller.doAction("GET_ALL_COURSES\n");
		System.out.println(response);
	}

	private void obfuscateData() {
		System.out.print("Course name: ");
		String courseName = scanner.nextLine();
		System.out.print("Email to obfuscate: ");
		String email = scanner.nextLine();
		String request = "OBFUSCATE_DATA\n" + courseName + "\n" + email;
		String response = controller.doAction(request);
		System.out.println(response);
	}
	
	private void showAverageGrade() {
	    System.out.print("Course name: ");
	    String courseName = scanner.nextLine();
	    String request = "GET_AVERAGE_GRADE\n" + courseName;
	    String response = controller.doAction(request);
	    System.out.println(response);
	}

	private void showParticipants() {
		System.out.print("Course name: ");
	    String courseName = scanner.nextLine().trim();  
	    if (courseName.isEmpty()) {
	        System.out.println("Название курса не может быть пустым.");
	        return;
	    }
	    String request = "GET_PARTICIPANTS\n" + courseName;
	    String response = controller.doAction(request);
	    System.out.println(response);
	}

	private void showStaff() {
		System.out.print("Course name: ");
	    String courseName = scanner.nextLine().trim();  
	    if (courseName.isEmpty()) {
	        System.out.println("Название курса не может быть пустым.");
	        return;
	    }
	    String request = "GET_STAFF\n" + courseName;
	    String response = controller.doAction(request);
	    System.out.println(response);
	}

}
