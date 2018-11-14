package br.pucrio.poo.controllers;

import java.util.List;

import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.views.board.CasaJogo;

public class TurnInitializerController {
	private DicesController dicesController;
	private OperationsController operationsController;

	public TurnInitializerController(DicesController dicesController, OperationsController operationsController) {
		this.dicesController = dicesController;
		this.operationsController = operationsController;
	}

	public void startTurnOf(Player player, List<CasaJogo> casas) {
		dicesController.enableRolling(player, casas);
		operationsController.enableTo(player);
	}
}
