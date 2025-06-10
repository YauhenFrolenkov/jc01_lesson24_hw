package com.edu.educational_system.controller.impl;

import java.util.List;
import com.edu.educational_system.controller.Command;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceExeption;
import com.edu.educational_system.service.CourseServiceProvider;

public class GetAllCourses implements Command{
	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService service = courseServiceProvider.getCourseService();
	
	@Override
    public String execute(String request) {
        try {
            List<Course> courses = service.getAllCourses();
            if (courses.isEmpty()) return "Courses not found.";
            StringBuilder sb = new StringBuilder("Course list:\n");
            for (Course c : courses) sb.append(c.getName()).append("\n");
            return sb.toString();
        } catch (CourseServiceExeption e) {
            return "Error: " + e.getMessage();
        }
    }

}
