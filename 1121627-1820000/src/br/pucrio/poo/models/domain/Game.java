package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.pucrio.poo.models.BoardSpotsCalculations;

public class Game {

	private static final int SPOTS_QUANTITY = 57;
	
	private static Game instance;

	private List<Player> players;
	private int currentIndex;
	private BoardSpotsCalculations boardCalculation;

	private Game(List<Player> players, final int boardWidth, final int boardHeight) {
		this.currentIndex = 0;
		this.players = players;
		this.boardCalculation = new BoardSpotsCalculations(boardWidth, boardHeight);
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

	public boolean canMove(int spotNumber) {
		Player player = this.currentPlayer();
		int relativeSpotNumber = boardCalculation.getRelativeSpotNumberFromSpotNumber(spotNumber, player.getColor());
		if (player.canMove(relativeSpotNumber) == false) {
			return false;
		}
	  // textar barreira, casa preta 
			
		return true;
	}
	
	public void movePlayer(int spotNumber) {
		Player player = this.currentPlayer();
		int relativeSpotNumber = boardCalculation.getRelativeSpotNumberFromSpotNumber(spotNumber, player.getColor());
		player.goForward(relativeSpotNumber);
		
		// se captura, go20Forward(relativeSpotnumber DO PIN Q TEM Q SE MOVIMENTAR)
	}
}