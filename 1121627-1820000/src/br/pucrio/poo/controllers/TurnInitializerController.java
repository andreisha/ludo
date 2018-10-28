package br.pucrio.poo.controllers;

import br.pucrio.poo.models.domain.Player;

public class TurnInitializerController {
	private DicesController dicesController;
	private OperationsController operationsController;

	public TurnInitializerController(DicesController dicesController, OperationsController operationsController) {
		this.dicesController = dicesController;
		this.operationsController = operationsController;
	}

	public void startTurnOf(Player player) {
		dicesController.enableRolling(player);
		operationsController.enableTo(player);
	}
}
