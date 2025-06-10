package com.edu.educational_system.main;

import com.edu.educational_system.controller.*;
import com.edu.educational_system.ui.CourseConsoleView;

public class Main {
	public static void main(String[] args) {
		CourseConsoleView view = new CourseConsoleView(
				new Controller());
		
		view.displayMenu();
	}

}
