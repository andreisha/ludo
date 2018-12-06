package br.pucrio.poo.controllers;

import br.pucrio.poo.models.domain.Player;

public class OperationsController {
	private static OperationsController instance;

	private LoadGameController loadGameController;
	private NewGameController newGameController;
	private SaveGameController saveGameController;

	private OperationsController(LoadGameController loadGameController,
			NewGameController newGameController, SaveGameController saveGameController) {
		this.saveGameController = saveGameController;
		this.newGameController = newGameController;
		this.loadGameController = loadGameController;
	}
	
	public static OperationsController getInstance(){
		if (instance == null) {	
			NewGameController newGameController = NewGameController.getInstance();
			LoadGameController loadGameController = LoadGameController.getInstance();
			SaveGameController saveGameController = SaveGameController.getInstance();
	    	instance = new OperationsController(loadGameController,	newGameController, saveGameController);
		}
		return instance;
	}

	public void enableTo(Player player) {
	}
}