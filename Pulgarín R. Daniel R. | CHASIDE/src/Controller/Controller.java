package Controller;

import Model.World;
import View.Interface;

public class Controller {

	private World world; // This is the Model(world)
	private Interface view; // This is the interface
	private String option;

	
	public Controller() {
		
		// Constructors
		world = new World();
		view = new Interface();
			
		// Welcome Message
		view.writeData("TEST VOCACIONAL 'CHASIDE'" + "\n"
				+ "-----------------------------------------" + "\n"
				+ "		Este TEST consta de  98 preguntas, las cuales deben de ser respondidas si o no usando " + "\n"
				+ "			1 (sí)" + "\n"
				+ "			0 (no)");
		
		
		// Answers
		world.fillQuestionaryAnswers(view.askDataAsArray(world.readFile()));	
		
		// Resutl
		view.writeTable(world.buildTableFromData());
		   
	}
}
