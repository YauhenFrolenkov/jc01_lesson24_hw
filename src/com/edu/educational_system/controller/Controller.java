 package com.edu.educational_system.controller;

public class Controller {
private final char paramDelimeter = '\n';
	
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) {

		
		String commandName;
		Command executionCommand;
		
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName.toUpperCase());
		
		String response;
		response = executionCommand.execute(request);
		
		return response;

	}
	

}
