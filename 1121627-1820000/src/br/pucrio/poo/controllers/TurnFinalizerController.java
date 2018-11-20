package br.pucrio.poo.controllers;

import java.util.List;

import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.views.board.*;
public class TurnFinalizerController {

	private BoardController boardController;
	private Game game;
	private TurnInitializerController turnInitializer;

	public TurnFinalizerController(BoardController boardController, Game game) {
		this.boardController = boardController;
		this.game = game;
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

		this.boardController.update();
		return currentPlayer;
	}

	public void setTurnInitializer(TurnInitializerController turnInitializer) {
		this.turnInitializer = turnInitializer;
	}

}
