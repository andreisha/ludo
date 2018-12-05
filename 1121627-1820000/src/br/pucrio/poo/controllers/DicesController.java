package br.pucrio.poo.controllers;

import java.awt.Image;
import java.util.List;

import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.utils.Resources;
import br.pucrio.poo.utils.IObserver;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.DicesPanel;
import br.pucrio.poo.views.board.Casa;

public class DicesController {

	private DicesPanel dicesPanel;
	private PlayerWalkController walkController;
	private TurnFinalizerController turnFinalizer;
	private Game game;

	public DicesController(Game game, PlayerWalkController walkController, TurnFinalizerController turnFinalizer) {
		this.game = game;
		this.walkController = walkController;
		this.turnFinalizer = turnFinalizer;
	}

	public void enableRolling(Player player) {
		player.notifyResultObservers();
	}

	public void roll(Player player) throws Exception {

		player.rollDices();
		
		if (!player.canPlayAgain()) {
			turnFinalizer.finalizeTurn();
		} 
	}
	public void roll(Player player, int numero) throws Exception {
		player.rollDices(numero);
		
		if (!player.canPlayAgain()) {
			turnFinalizer.finalizeTurn();
		} 
	}

	public Image getDiceImage(Player player) {
		if(player.getDice() == null)
			return null;
		
		int diceResult = player.getDiceResult();
		return getDiceImage(diceResult);
	}
	
	private Image getDiceImage(int value) {
		return Resources.getDiceImage(value);
	}

	public void registerObserver(IObserver observer) {
		List<Player> players = this.game.getPlayers();
		for (Player player : players) {
			player.registerResultObserver(observer);
		}
	}

}
