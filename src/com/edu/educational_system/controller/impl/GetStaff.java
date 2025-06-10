package com.edu.educational_system.controller.impl;

import java.util.List;

import com.edu.educational_system.controller.Command;
import com.edu.educational_system.model.Person;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceExeption;
import com.edu.educational_system.service.CourseServiceProvider;

public class GetStaff implements Command{
	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService service = courseServiceProvider.getCourseService();
	
	@Override
    public String execute(String request) {
        String[] lines = request.split("\n");
        if (lines.length < 2) {
            return "Course name not specified.";
        }
        String courseName = lines[1].trim();

        try {
            List<Person> staff = service.getStaff(courseName);

            if (staff.isEmpty()) return "No instructors.";
            StringBuilder sb = new StringBuilder("Staff:\n");
            for (Person p : staff) {
                sb.append(p.getName()).append(" (").append(p.getEmail()).append(")\n");
            }
            return sb.toString();
        } catch (CourseServiceExeption e) {
            return "Course with the name '" + courseName + "' not found.";
        }
    }
	
}
