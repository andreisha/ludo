package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.pucrio.poo.models.BoardSpotsCalculations;
import br.pucrio.poo.models.Position;

public class Game {

	private static final int SPOTS_QUANTITY = 57;
	private static final int RELATIVE_INITIAL_SPOT = 0;
	
	private static Game instance;

	private List<Player> players;
	private int currentIndex;
	private BoardSpotsCalculations boardSpotsCalculations;

	private Game(List<Player> players, final int boardWidth, final int boardHeight) {

		this.currentIndex = 0;
		this.players = players;
		this.boardSpotsCalculations = new BoardSpotsCalculations(boardWidth, boardHeight);
	}

	public Player currentPlayer() {
		return this.players.get(currentIndex);
	}

	public void endPlayerTurn() {
		currentIndex++;
		currentIndex %= players.size();
	}
	
	public static Game getInstance(final int boardWidth, final int boardHeight) throws Exception {
		if (instance == null) {
			// initializing models
			List<Player> players = Arrays.asList(
					new Player("Player 0", PlayerColor.RED, SPOTS_QUANTITY),
					new Player("Player 1", PlayerColor.GREEN, SPOTS_QUANTITY),
					new Player("Player 2", PlayerColor.YELLOW, SPOTS_QUANTITY),
					new Player("Player 3", PlayerColor.BLUE, SPOTS_QUANTITY));		
			 
	    	instance = new Game(players, boardWidth, boardHeight);
		}
		return instance;
	}

	public List<Player> getPlayers() {
		return new ArrayList<Player>(players);
	}
	
	public boolean isInitialSpotBloqued() {
		
		int initialSpot = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(RELATIVE_INITIAL_SPOT, currentPlayer().getColor());		
		return isSpotBloqued(initialSpot);
	}
	
	public boolean isSpotBloqued(int targetRelativeSpot) {
		int pinsAtTargetSpot = 0;
		
		int targetSpot = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(targetRelativeSpot, currentPlayer().getColor());
		
		List<Player> players = getPlayers();
		for (Player player : players) {
			for (int relativeSpotNumber : player.getSpotNumbers()) {
				int spotNumber = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(relativeSpotNumber, player.getColor());
				
				if(spotNumber == targetSpot) {
					pinsAtTargetSpot++;
					
					if(pinsAtTargetSpot > 1)
						return true;
				}
			}
		}		
		return false;
	}
	
	public Player getPlayerFromColor(PlayerColor color) {
		for (Player player : getPlayers()) {
			if(player.getColor() == color) 
				return player;
		}
		return null;
	}

	public boolean isPlayerTurn(PlayerColor color) {
		 return color == currentPlayer().getColor();
	}
	
	public boolean isHomeSpot(int spotNumber) {
		Player currentPlayer = this.currentPlayer();
		int relativeSpotNumber = boardSpotsCalculations.getRelativeSpotNumberFromSpotNumber(spotNumber, currentPlayer.getColor());
		return currentPlayer.isHomeSpot(relativeSpotNumber);
	}
	
	public boolean canLeaveHome() {
		Player currentPlayer = this.currentPlayer();
		
		if(!currentPlayer.canLeaveHome())
			return false;		
		
		if(isInitialSpotBloqued())
			return false;
		
		return true;
	}
	
	public void leaveHome() {
		this.currentPlayer().leaveHome();		
	}

	public boolean canMove() {		
		Player currentPlayer = this.currentPlayer();
		List<Integer> currentPlayerSpotNumbers = currentPlayer.getSpotNumbers();		
		
		for (int relativeSpotNumber : currentPlayerSpotNumbers) {
			int spotNumber = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(relativeSpotNumber, currentPlayer.getColor());
			if (canMove(spotNumber)) 
				return true;			
		}				
		return false;
	}
	
	public boolean canPlayAgain() {
		return this.currentPlayer().canPlayAgain();
	}
	
	public boolean canMove(int spotNumber) {
		Player currentPlayer = this.currentPlayer();
		int relativeSpotNumber = boardSpotsCalculations.getRelativeSpotNumberFromSpotNumber(spotNumber, currentPlayer.getColor());
		int steps = currentPlayer.getDicePoints();
		
		if (!currentPlayer.canMove(relativeSpotNumber)) 
			return false;
		
		int targetRelativeSpot = relativeSpotNumber + steps;
		
		if(isSpotBloqued(targetRelativeSpot))
			return false;
		
		// textar barreira, casa preta 
		
		return true;
	}
	
	public void movePlayer(int spotNumber) {
		Player player = this.currentPlayer();
		int relativeSpotNumber = boardSpotsCalculations.getRelativeSpotNumberFromSpotNumber(spotNumber, player.getColor());
		player.goForward(relativeSpotNumber);
		
		// se captura, go20Forward(relativeSpotnumber DO PIN Q TEM Q SE MOVIMENTAR)
	}		
}


