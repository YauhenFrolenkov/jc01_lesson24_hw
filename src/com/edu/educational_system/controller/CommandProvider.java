package com.edu.educational_system.controller;

import java.util.HashMap;
import java.util.Map;

import com.edu.educational_system.controller.impl.*;

public class CommandProvider {
private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.CREATE_COURSE, new CreateCourse());
		repository.put(CommandName.REGISTER_PERSON, new RegisterPerson());
		repository.put(CommandName.START_LESSON, new StartLesson());
		repository.put(CommandName.GET_PARTICIPANTS, new GetParticipants());
		repository.put(CommandName.GET_STAFF, new GetStaff());
		repository.put(CommandName.GET_AVERAGE_GRADE, new GetAverageGrade());
		repository.put(CommandName.GET_ALL_COURSES, new GetAllCourses());
		repository.put(CommandName.OBFUSCATE_DATA, new ObfuscateData());
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
		repository.put(CommandName.SHOW_SPECIAL_COURSE_INFO, new ShowSpecialCourseInfo());
	}
	
	Command getCommand(String name){
		CommandName commandName =null;
		Command command = null;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e){
			command = repository.get(CommandName.WRONG_REQUEST);
		}				
		return command;
	}

}
