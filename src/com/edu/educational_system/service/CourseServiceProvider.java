package com.edu.educational_system.service;

import com.edu.educational_system.service.impl.DoCourseService;

public final class CourseServiceProvider {
	private static final CourseServiceProvider instance = new CourseServiceProvider();
	
	private final CourseService courseService = new DoCourseService();

	private CourseServiceProvider() {
	}
	
	public CourseService getCourseService() {
		return courseService;
	}	
	
	public static CourseServiceProvider getInstance() {
		return instance;
	}
	
	
}
