package br.pucrio.poo.controllers;

public class LoadGameController {
	
	private static LoadGameController instance;

	private LoadGameController() {

	}
	
	public static LoadGameController getInstance(){
		if (instance == null) {			 
	    	instance = new LoadGameController();
		}
		return instance;
	}

	public void loadGame() {
		// TODO Auto-generated method stub
		
	}

}
