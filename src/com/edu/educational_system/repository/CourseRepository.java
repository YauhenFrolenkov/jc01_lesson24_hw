package com.edu.educational_system.repository;

import java.util.List;
import com.edu.educational_system.model.Course;

public interface CourseRepository {
	void addNewCourse(Course course) throws CourseRepositoryExeption;
	void updateCourse(Course course) throws CourseRepositoryExeption;
	List<Course> getAllCourses() throws CourseRepositoryExeption;
	void obfuscateStudentInCourse(String courseName, String studentEmail) throws CourseRepositoryExeption;
	Course findCourseByName(String courseName) throws CourseRepositoryExeption;
	
}
