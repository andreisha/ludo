package br.pucrio.poo.controllers;

import br.pucrio.poo.controllers.spot.SpotFrontController;
import br.pucrio.poo.models.domain.Player;

public class PlayerWalkController {

	private BoardController boardController;
	private TurnFinalizerController turnFinalizer;
	private SpotFrontController spotFrontController;

	public PlayerWalkController(BoardController boardController, TurnFinalizerController turnFinalizer,
			SpotFrontController spotFrontController) {
		this.boardController = boardController;
		this.turnFinalizer = turnFinalizer;
		this.spotFrontController = spotFrontController;
	}

	public void playerWalk(Player player) {
		int steps = player.getDicePoints();

		player.goForward(steps);
		boardController.update();

		//this.spotFrontController.spotActivatedBy(player, turnFinalizer);
	}
}
