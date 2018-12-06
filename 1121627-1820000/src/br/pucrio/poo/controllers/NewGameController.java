package br.pucrio.poo.controllers;

public class NewGameController {
	private static NewGameController instance;

	private NewGameController () {

	};
	
	public static NewGameController getInstance(){
		if (instance == null) {			 
	    	instance = new NewGameController();
		}
		return instance;
	}

	public void startNewGame(int boardWidth, int boardHeight) {
		// TODO Auto-generated method stub
		
	}

}
