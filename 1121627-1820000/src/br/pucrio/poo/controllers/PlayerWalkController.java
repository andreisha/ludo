package br.pucrio.poo.controllers;

import br.pucrio.poo.controllers.spot.SpotFrontController;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.domain.PlayerColor;

public class PlayerWalkController {

	private BoardController boardController;
	private TurnFinalizerController turnFinalizer;
	private SpotFrontController spotFrontController;
	private Game game;
	
	public PlayerWalkController(BoardController boardController, TurnFinalizerController turnFinalizer,
			SpotFrontController spotFrontController, Game game) {
		this.boardController = boardController;
		this.turnFinalizer = turnFinalizer;
		this.spotFrontController = spotFrontController;
		this.game = game;
	}
	
	public void playerWalk(Player player, int spotNumber) {
		int steps = player.getDicePoints();
		
		player.goForward(steps,spotNumber);
		boardController.update();
		
		this.spotFrontController.spotActivatedBy(player, turnFinalizer);
	}
	
	public void playerWalk(PlayerColor color, int spotNumber) {
		//Player player = null;
		for (Player player : game.getPlayers()) {
			if(player.getColor() == color) {
				int steps = player.getDicePoints();				
				player.goForward(steps,spotNumber);
				boardController.update();
				this.spotFrontController.spotActivatedBy(player, turnFinalizer);
			}				
		}			
	}
}
