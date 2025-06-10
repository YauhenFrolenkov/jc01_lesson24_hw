package com.edu.educational_system.controller.impl;

import java.util.List;
import com.edu.educational_system.controller.Command;
import com.edu.educational_system.model.Administrator;
import com.edu.educational_system.model.Person;
import com.edu.educational_system.model.Teacher;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceExeption;
import com.edu.educational_system.service.CourseServiceProvider;

public class ShowSpecialCourseInfo implements Command {
	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService service = courseServiceProvider.getCourseService();
	
	@Override
	public String execute(String request) {
	    
	    String[] lines = request.split("\n");
	    if (lines.length < 2) {
	        return "Invalid request. Please specify the course name.";
	    }

	    String courseName = lines[1].trim();
	    try {
            service.findCourseByName(courseName);
        } catch (CourseServiceExeption e) {
            return "Course with the name '" + courseName + "' not found."; 
        }

	    StringBuilder sb = new StringBuilder("Course information: ").append(courseName).append("\n");

	    
	    List<Person> participants;
        try {
            participants = service.getParticipants(courseName);
        } catch (CourseServiceExeption e) {
            return "Error retrieving student list: " + e.getMessage();
        }
        sb.append("\nStudents:\n");
        if (participants.isEmpty()) {
            sb.append("No students.\n");
        } else {
            for (Person p : participants) {
                sb.append("- ").append(p.getName()).append(" (").append(p.getEmail()).append(")\n");
            }
        }

	    
        List<Person> staff;
        try {
            staff = service.getStaff(courseName);
        } catch (CourseServiceExeption e) {
            return "Error retrieving staff list: " + e.getMessage();
        }

	    
	    sb.append("\nInstructors:\n");
        boolean hasTeachers = false;
        for (Person p : staff) {
            if (p instanceof Teacher) {
                sb.append("- ").append(p.getName()).append(" (").append(p.getEmail()).append(")\n");
                hasTeachers = true;
            }
        }
        if (!hasTeachers) sb.append("No instructors.\n");

	    
        sb.append("\nAdministrators:\n");
        boolean hasAdmins = false;
        for (Person p : staff) {
            if (p instanceof Administrator) {
                sb.append("- ").append(p.getName()).append(" (").append(p.getEmail()).append(")\n");
                hasAdmins = true;
            }
        }
        if (!hasAdmins) sb.append("No administrators.\n");

	    return sb.toString();
	}
}
