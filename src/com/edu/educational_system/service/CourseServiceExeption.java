package com.edu.educational_system.service;

public class CourseServiceExeption extends Exception{
	private static final long serialVersionUID = 1L;
	
	public CourseServiceExeption(){
		super();
	}
	
	public CourseServiceExeption(String message){
		super(message);
	}
	
	public CourseServiceExeption(Exception e){
		super(e);
	}
	
	public CourseServiceExeption(String message, Exception e){
		super(message, e);
	}

}
