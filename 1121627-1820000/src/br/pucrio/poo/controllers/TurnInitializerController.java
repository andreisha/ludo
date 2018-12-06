package br.pucrio.poo.controllers;
import br.pucrio.poo.models.domain.Player;

public class TurnInitializerController {
	private static TurnInitializerController instance;
	
	private DicesController dicesController;
	private OperationsController operationsController;

	private TurnInitializerController(DicesController dicesController, OperationsController operationsController) {
		this.dicesController = dicesController;
		this.operationsController = operationsController;
	}
	
	public static TurnInitializerController getInstance(DicesController dicesController, OperationsController operationsController){
		if (instance == null) {			 
	    	instance = new TurnInitializerController(dicesController, operationsController);
		}
		return instance;
	}

	public void startTurnOf(Player player) {
		dicesController.enableRolling(player);
		operationsController.enableTo(player);
	}
}
