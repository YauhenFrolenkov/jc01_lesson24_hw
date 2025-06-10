package com.edu.educational_system.service;

import java.util.List;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.model.Person;


public interface CourseService {
	void createCourse(Course course) throws CourseServiceExeption;
	boolean enrollPerson(Course course, Person person) throws CourseServiceExeption;
	void conductLesson(Course course);
	List<Person> getParticipants(String courseName) throws CourseServiceExeption;
	List<Person> getStaff(String courseName) throws CourseServiceExeption;
	double getAverageGrade(Course course);
	List<Course> getAllCourses() throws CourseServiceExeption;
	void obfuscateData(String nameOfCourse, String email) throws CourseServiceExeption;
	Course findCourseByName(String name) throws CourseServiceExeption;

}
