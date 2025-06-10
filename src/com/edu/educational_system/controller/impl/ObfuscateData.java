package com.edu.educational_system.controller.impl;

import com.edu.educational_system.controller.Command;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceExeption;
import com.edu.educational_system.service.CourseServiceProvider;

public class ObfuscateData implements Command {
	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService service = courseServiceProvider.getCourseService();
	
	@Override
    public String execute(String request) {
        String[] params = request.split("\n");
        if (params.length < 3) return "Invalid request format.";

        String courseName = params[1];
        String email = params[2];

        try {
			service.obfuscateData(courseName, email);
		} catch (CourseServiceExeption e) {
			return "Error. Personal data is not hidden.";
		}
        return "Personal data is hidden.";
    }
}
	
