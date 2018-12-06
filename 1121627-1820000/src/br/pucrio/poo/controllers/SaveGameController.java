package br.pucrio.poo.controllers;

public class SaveGameController {
	
	private static SaveGameController instance;

	public SaveGameController() {

	}
	
	public static SaveGameController getInstance(){
		if (instance == null) {			 
	    	instance = new SaveGameController();
		}
		return instance;
	}

	public void saveGame() {
		// TODO Auto-generated method stub
		
	}
}
