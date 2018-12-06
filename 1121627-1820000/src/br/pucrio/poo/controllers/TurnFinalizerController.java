package br.pucrio.poo.controllers;
import br.pucrio.poo.models.domain.Game;

import br.pucrio.poo.models.domain.Player;
public class TurnFinalizerController {
	private static TurnFinalizerController instance;
	
	private Game game;
	private TurnInitializerController turnInitializer;

	private TurnFinalizerController(BoardController boardController, Game game) {
		this.game = game;
	}
	
	public static TurnFinalizerController getInstance(BoardController boardController, Game game){
		if (instance == null) {			 
	    	instance = new TurnFinalizerController(boardController, game);
		}
		return instance;
	}

	public void finalizeTurn() {
		Player player = this.game.currentPlayer();
		Player currentPlayer;

		boolean canPlayAgain = player.canPlayAgain();
		if (canPlayAgain) {
			currentPlayer = player;
		} else {
			currentPlayer = passTurn(player);
		}
		this.turnInitializer.startTurnOf(currentPlayer);
	}

	private Player passTurn(Player lastPlayer) {
		this.game.endPlayerTurn();
		Player currentPlayer = this.game.currentPlayer();
		return currentPlayer;
	}

	public void setTurnInitializer(TurnInitializerController turnInitializer) {
		this.turnInitializer = turnInitializer;
	}

}