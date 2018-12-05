package br.pucrio.poo.controllers;

import br.pucrio.poo.controllers.spot.SpotFrontController;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.Pin;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.domain.PlayerColor;

public class PlayerWalkController {

	private BoardController boardController;
	private TurnFinalizerController turnFinalizer;
	private Game game;
	
	public PlayerWalkController(BoardController boardController, TurnFinalizerController turnFinalizer, Game game) {
		this.boardController = boardController;
		this.turnFinalizer = turnFinalizer;
		this.game = game;
	}
	
	public void playerWalk(PlayerColor color, int spotNumber) {
		if(!isPlayerTurn(color))
			return;
		
		Player player = getPlayerFromColor(color);		
		if(player == null)
			return;
		
		int relativeSpotNumber = boardController.getRelativeSpotNumberFromSpotNumber(spotNumber, color);
		
	/*	if (player.isHomeSpot(relativeSpotNumber)) {
			if (canLeaveHome(player)) {
				player.leaveHome();				
			}
			return;
		}*/
		
		if(!canMove(player,spotNumber)) {
			turnFinalizer.finalizeTurn();
			return;	
			}
		
		game.movePlayer(spotNumber);
		
		
	}
	
	private boolean canLeaveHome(Player player) {
		if(!player.shouldLeaveHome())
			return false;
		
		//verificar se não pode posicionar um peão na casa de saída
		if(isInitialSpotBloqued(player))
			return false;
		
		return true;
	}
	
	public boolean isInitialSpotBloqued(Player player) {
		return boardController.isInitialSpotBloqued(player.getColor());
	}

	private boolean canMove(Player player, int spotNumber) {				
		int relativeSpotNumber = boardController.getRelativeSpotNumberFromSpotNumber(spotNumber, player.getColor());
		
		if(!game.canMove(spotNumber))
			return false;
				
		int steps = player.getDicePoints();
		int targetSpot = relativeSpotNumber + steps;
		
		if(isSpotBloqued(targetSpot))
			return false;
		
		return true;
	}
	
	private boolean isSpotBloqued(int spotNumber) {
		return boardController.isSpotBloqued(spotNumber);
	}

	private Player getPlayerFromColor(PlayerColor color) {
		for (Player player : game.getPlayers()) {
			if(player.getColor() == color) 
				return player;
		}
		return null;
	}
	
	private boolean isPlayerTurn(PlayerColor color) {
		 return color == game.currentPlayer().getColor();
	}
	public boolean isPlayerTurn(Player player) {
		 return player == game.currentPlayer();
	}
}