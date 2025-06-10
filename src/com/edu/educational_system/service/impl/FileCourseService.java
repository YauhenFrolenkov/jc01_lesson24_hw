package com.edu.educational_system.service.impl;

import java.util.List;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.model.Person;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceExeption;

public class FileCourseService implements CourseService {

	@Override
	public void createCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean enrollPerson(Course course, Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void conductLesson(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getAverageGrade(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void obfuscateData(String nameOfCourse, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course findCourseByName(String name) throws CourseServiceExeption {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getParticipants(String courseName) throws CourseServiceExeption {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getStaff(String courseName) throws CourseServiceExeption {
		// TODO Auto-generated method stub
		return null;
	}
	

}
