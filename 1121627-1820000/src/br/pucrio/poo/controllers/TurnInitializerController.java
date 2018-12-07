package br.pucrio.poo.controllers;
import br.pucrio.poo.models.domain.Player;

public class TurnInitializerController {
	private static TurnInitializerController instance;
	
	private DicesController dicesController;

	private TurnInitializerController(DicesController dicesController) {
		this.dicesController = dicesController;
	}
	
	public static TurnInitializerController getInstance(DicesController dicesController){
		if (instance == null) {			 
	    	instance = new TurnInitializerController(dicesController);
		}
		return instance;
	}

	public void startTurnOf(Player player) {
		dicesController.enableRolling(player);
	}
}
