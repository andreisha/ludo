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

	public void finalizeTurn(List<CasaJogo> casas) {
		Player player = this.game.currentPlayer();
		Player currentPlayer;

		boolean canPlayAgain = player.canPlayAgain();
		if (canPlayAgain) {
			currentPlayer = player;
		} else {
			currentPlayer = passTurn(player, casas);
		}
		this.turnInitializer.startTurnOf(currentPlayer, casas);
	}

	private Player passTurn(Player lastPlayer, List<CasaJogo> casas) {
		this.game.endPlayerTurn();
		Player currentPlayer = this.game.currentPlayer();

		this.boardController.update(casas);
		return currentPlayer;
	}

	public void setTurnInitializer(TurnInitializerController turnInitializer) {
		this.turnInitializer = turnInitializer;
	}

}
