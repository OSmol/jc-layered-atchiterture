package edu.examples.java_classes.main;

import edu.examples.java_classes.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		String request;
		String response;
		
		request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
		response = controller.doAction(request);
		System.out.println(response);
		
		
		request = "UPDATE\nid=2\ntitle=Книга\ncontent=Туманность Андромеды\ndate=2023-08-08";
		response = controller.doAction(request);
		System.out.println(response);		
	}

}
