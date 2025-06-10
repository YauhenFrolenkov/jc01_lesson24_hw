package com.edu.educational_system.repository;

import com.edu.educational_system.repository.impl.MemoryCourseRepository;

public final class CourseRepositoryProvider {
	private static final CourseRepositoryProvider instance = new CourseRepositoryProvider();
	
	private final CourseRepository courseRepository = new MemoryCourseRepository();

	private CourseRepositoryProvider() {
	}

	public CourseRepository getCourseRepository() {
		return courseRepository;
	}
	
	public static CourseRepositoryProvider getInstance() {
		return instance;
	}
	

}
