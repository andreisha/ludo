package br.pucrio.poo.controllers;

import java.awt.Image;
import java.util.List;

import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.utils.Resources;
import br.pucrio.poo.utils.IEnableToObserver;
import br.pucrio.poo.utils.IObserver;

public class DicesController {
	private static DicesController instance;
	
	private Game game;
	private PlayerWalkController playerWalkController;

	private DicesController(Game game, PlayerWalkController playerWalkController) {
		this.game = game;
		this.playerWalkController = playerWalkController;
	}
	
	public static DicesController getInstance(Game game, PlayerWalkController playerWalkController){
		if (instance == null) {			 
	    	instance = new DicesController(game, playerWalkController);
		}
		return instance;
	}

	public void enableRolling(Player player) {
		player.notifyEnableToObservers();
	}

	public void roll(Player player){
		player.rollDices();		
		playerWalkController.doAutomaticMoves();		
	}
	public void roll(Player player, int numero){
		player.rollDices(numero);
		playerWalkController.doAutomaticMoves();
	}

	public Image getDiceImage(Player player) {
		if(!player.hasDice())
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
	
	public void registerEnableToObserver(IEnableToObserver observer) {
		List<Player> players = this.game.getPlayers();
		for (Player player : players) {
			player.registerEnableToObserver(observer);
		}
	}

}
