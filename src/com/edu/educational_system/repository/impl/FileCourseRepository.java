package com.edu.educational_system.repository.impl;

import java.util.List;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.repository.CourseRepository;
import com.edu.educational_system.repository.CourseRepositoryExeption;

public class FileCourseRepository implements CourseRepository {

	@Override
	public List<Course> getAllCourses() throws CourseRepositoryExeption {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void obfuscateStudentInCourse(String courseName, String studentEmail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course findCourseByName(String courseName) throws CourseRepositoryExeption {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}
	

}
