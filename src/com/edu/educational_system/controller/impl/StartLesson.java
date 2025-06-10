package com.edu.educational_system.controller.impl;

import com.edu.educational_system.controller.Command;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceProvider;

public class StartLesson implements Command {
	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService service = courseServiceProvider.getCourseService();

    @Override
    public String execute(String request) {
        try {
            String[] params = request.split("\n");
            String courseName = params[1];
            Course course = new Course(courseName);
            service.conductLesson(course);
            return "Class successfully completed.";
        } catch (Exception e) {
            return "Error conducting class.";
        }
    }
	

}
