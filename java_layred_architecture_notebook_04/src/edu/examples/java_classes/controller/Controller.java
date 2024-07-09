package edu.examples.java_classes.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class Controller {// FrontController
	private final char paramDelimeter = '\n';
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();
	
	//ADD\ntitle=Книга\nсоntent=Туманность Андромеды
	public String doAction(String request) {
		String command;
		command = request.substring(0, request.indexOf(paramDelimeter));
		command = command.toUpperCase();
		
		String response = null;
		String[] params;
		Note newNote;
		switch(command){
		case "ADD":
			//validate request
			params = request.split(paramDelimeter+"");
			newNote = new Note();
			newNote.setTitle(params[1].split("=")[1]);
			newNote.setContent(params[2].split("=")[1]);
			
			logic.add(newNote);
			response = "Запись сохранена успешно.";
			break;
		case "UPDATE":
			//validate request
			params = request.split(paramDelimeter+"");
			newNote = new Note();
			
			newNote.setId(Integer.parseInt(params[1].split("=")[1]));
			newNote.setTitle(params[2].split("=")[1]);
			newNote.setContent(params[3].split("=")[1]);
			
			SimpleDateFormat format = new SimpleDateFormat();
			format.applyPattern("yyyy-mm-dd");
			Date date;
			try {
				date = format.parse(params[4].split("=")[1]);
				newNote.setD(date);
				
				logic.add(newNote);
				response = "Запись обновлена успешно.";
			} catch (ParseException e) {
				e.printStackTrace();
				response = "Запись необновлена.";
			}
			
			break;
		default:
			response = "We can't execute this command";	
		}
		
		return response;

	}

}

//ADD\ntitle=Книга\nсоntent=Туманность Андромеды
//OK\nmessage=Ваше сообщение было сохранено
//ERROR\nerrorMessage=Сообщение сохранить не удалось. Попробуйте еще раз.


//UPDATE\nid=2\ntitle=Книга\ncontent=Туманность Андромеды\ndate=2023-08-08


//FIND_BY_TEXT\nтуманность



//FIND_BY_DATE\n2023-19-09



//ALL_NOTES



