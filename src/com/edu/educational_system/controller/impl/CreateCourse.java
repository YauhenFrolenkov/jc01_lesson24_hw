package com.edu.educational_system.controller.impl;

import com.edu.educational_system.controller.Command;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceExeption;
import com.edu.educational_system.service.CourseServiceProvider;

public class CreateCourse implements Command {

	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService service = courseServiceProvider.getCourseService();

	@Override
	public String execute(String request) {
		String response;
		try {
			String[] params = request.split("\n");
			if (params.length < 2 || params[1].isBlank()) {
				return "Error: Course name is required.";
			}
			String courseName = params[1];
			Course newCourse = new Course(courseName);

			service.createCourse(newCourse);
			response = "Course created successfully: " + courseName;
		} catch (CourseServiceExeption e) {
			response = "Error creating course: ";
		}
		return response;
	}

}
