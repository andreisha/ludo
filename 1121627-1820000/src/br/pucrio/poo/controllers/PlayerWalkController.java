package br.pucrio.poo.controllers;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.PlayerColor;

public class PlayerWalkController {
	private static PlayerWalkController instance;
	
	private TurnFinalizerController turnFinalizer;
	private Game game;
	
	private PlayerWalkController(TurnFinalizerController turnFinalizer, Game game) {
		this.turnFinalizer = turnFinalizer;
		this.game = game;
	}
	
	public static PlayerWalkController getInstance(TurnFinalizerController turnFinalizer, Game game){
		if (instance == null) {			 
	    	instance = new PlayerWalkController(turnFinalizer, game);
		}
		return instance;
	}
	
	public void playerWalk(PlayerColor color, int spotNumber) {
		if (!isPlayerTurn(color))
			return;
		
		if (!spotEnabled(color, spotNumber))
			return;
		
		if (isHomeSpot(spotNumber)) {			
			return;
		}

		if (!canMove(spotNumber)) {			
			if(!canMove()) { // && !canPlayAgain()) {
				finalizeTurn();
			}
			return;
		}

		movePlayer(spotNumber);
		
		
		finalizeTurn();
				
	}
	
	private void movePlayer(int spotNumber) {
		game.movePlayer(spotNumber);
	}
	
	private boolean canLeaveHome() {		
		return game.canLeaveHome();
	}
	
	private boolean needsGoHome() {		
		return game.currentPlayer().needsGoHome();
	}
	
	private void goHome() {		
		game.currentPlayer().goHome();
	}
	
	private boolean needsOpenBarreira() {		
		return game.currentPlayer().needsOpenBarreira();
	}
	
	private void openBarreira() {		
		game.openBarreira();
	}
	
	private void leaveHome(){
		game.leaveHome();
	}
	
	private boolean spotEnabled(PlayerColor color,int spotNumber){
		return game.isSpotEnabled(color, spotNumber);
	}
	
	private boolean isHomeSpot(int spotNumber) {
		return game.isHomeSpot(spotNumber);
	}
	
	private boolean canPlayAgain() {
		return game.canPlayAgain();
	}	
	
	private boolean canMove(int spotNumber) {				
		return game.canMove(spotNumber);
	}
	
	private boolean canMove() {
		return game.canMove();
	}
	
	private void finalizeTurn() {
		turnFinalizer.finalizeTurn();
	}
	
	public boolean isSpotBloqued(int spot) {
		return game.isSpotBloqued(spot);
	}
	
	public boolean isPlayerTurn(PlayerColor color) {
		 return game.isPlayerTurn(color);
	}				

	public void doAutomaticMoves() {		
		if (canLeaveHome()) {
			leaveHome();
			finalizeTurn();
			return;
		}
	
		if (needsGoHome()) {
			goHome();
			finalizeTurn();
			return;
		} 
		
		if (!canMove()) { //  && !canPlayAgain()) {
			finalizeTurn();
			return;
		} 
		
		if (needsOpenBarreira() && canMove()) {
			openBarreira();
			finalizeTurn();
			return;
		}
	}
}