package com.edu.educational_system.service.impl;

import java.util.List;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.model.Person;
import com.edu.educational_system.repository.CourseRepository;
import com.edu.educational_system.repository.CourseRepositoryExeption;
import com.edu.educational_system.repository.CourseRepositoryProvider;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceExeption;

public class DoCourseService implements CourseService {
	private final CourseRepository courseRepository;

	{
		CourseRepositoryProvider provider = CourseRepositoryProvider.getInstance();
		courseRepository = provider.getCourseRepository();
	}

	public DoCourseService() {
	}

	public void createCourse(Course course) throws CourseServiceExeption {
		try {
			courseRepository.addNewCourse(course);
		} catch (CourseRepositoryExeption e) {
			throw new CourseServiceExeption(e);
		}
	}

	public boolean enrollPerson(Course course, Person person) throws CourseServiceExeption {
		boolean success = course.addParticipant(person);
		if (success) {
			try {
				courseRepository.updateCourse(course);
			} catch (CourseRepositoryExeption e) {
				throw new CourseServiceExeption(e);
			}
		}
		return success;
	}

	public void conductLesson(Course course) {
		course.conductLesson();
	}

	public List<Person> getParticipants(String courseName) throws CourseServiceExeption {
		Course course = findCourseByName(courseName);
		return course.getParticipants();
	}

	public List<Person> getStaff(String courseName) throws CourseServiceExeption {
	    Course course = findCourseByName(courseName);
	    return course.getStaff();
	}

	public double getAverageGrade(Course course) {
		return course.calculateAverageGrade();
	}

	public List<Course> getAllCourses() throws CourseServiceExeption {
		try {
			return courseRepository.getAllCourses();
		} catch (CourseRepositoryExeption e) {
			throw new CourseServiceExeption(e);
		}
	}

	public void obfuscateData(String nameOfCourse, String email) throws CourseServiceExeption {
		try {
			courseRepository.obfuscateStudentInCourse(nameOfCourse, email);
		} catch (CourseRepositoryExeption e) {
			throw new CourseServiceExeption(e);
		}
	}

	public Course findCourseByName(String name) throws CourseServiceExeption {
		try {
			return courseRepository.findCourseByName(name);
		} catch (CourseRepositoryExeption e) {
			throw new CourseServiceExeption(e);
		}
	}

}
