package com.edu.educational_system.controller.impl;

import com.edu.educational_system.controller.Command;
import com.edu.educational_system.model.Administrator;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.model.Person;
import com.edu.educational_system.model.Student;
import com.edu.educational_system.model.Teacher;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceExeption;
import com.edu.educational_system.service.CourseServiceProvider;

public class RegisterPerson implements Command {
	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService service = courseServiceProvider.getCourseService();

	@Override
	public String execute(String request) {
		String response;
		try {
			String[] params = request.split("\n");

			if (params.length < 5) {
				return "Insufficient data. Expected: course name, name, email, role, additional parameters.";
			}

			String courseName = params[1];
			String personName = params[2];
			String email = params[3];
			String role = params[4];

			Course course = null;
			for (Course c : service.getAllCourses()) {
				if (c.getName().equalsIgnoreCase(courseName)) {
					course = c;
					break;
				}
			}

			if (course == null) {
				return "Course with the name '" + courseName + "' not found.";
			}

			Person person;
			switch (role.toLowerCase()) {
			case "student":
				if (params.length < 7) {
					return "For a student, group and average grade must be specified.";
				}
				String group = params[5];
				double avgGrade = Double.parseDouble(params[6]);
				person = new Student(personName, email, group, avgGrade);
				break;

			case "teacher":
				if (params.length < 6) {
					return "For an instructor, the subject must be specified.";
				}
				String subject = params[5];
				person = new Teacher(personName, email, subject);
				break;

			case "administrator":
				if (params.length < 6) {
					return "For an administrator, the department must be specified.";
				}
				String department = params[5];
				person = new Administrator(personName, email, department);
				break;

			default:
				return "Неизвестная роль: " + role;
			}

			service.enrollPerson(course, person);
			response = "User " + personName + " successfully registered for the course '" + courseName + "' as "
					+ role + ".";

		} catch (NumberFormatException e) {
			response = "Number format error (average grade)";
		} catch (CourseServiceExeption e) {
			response = "Ошибка при регистрации пользователя";
		}

		return response;
	}
}
