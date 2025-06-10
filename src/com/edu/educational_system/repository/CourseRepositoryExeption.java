package com.edu.educational_system.repository;

public class CourseRepositoryExeption extends Exception{
	private static final long serialVersionUID = 1L;
	
	public CourseRepositoryExeption(){
		super();
	}
	
	public CourseRepositoryExeption(String message){
		super(message);
	}
	
	public CourseRepositoryExeption(Exception e){
		super(e);
	}
	
	public CourseRepositoryExeption(String message, Exception e){
		super(message, e);
	}

}
