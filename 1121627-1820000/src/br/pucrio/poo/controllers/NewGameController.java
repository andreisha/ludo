package br.pucrio.poo.controllers;

import br.pucrio.poo.models.utils.Serializer;
import br.pucrio.poo.utils.Register;

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

	public void startNewGame(Serializer serializer) {
		Register register = serializer.getRegister();
		register.reset();		
	}

}
