package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

	private static final int SPOTS_QUANTITY = 57;
	
	private static Game instance;

	private List<Player> players;
	private int currentIndex;
	private Board board;

	private Game(List<Player> players, Board board) {
		this.currentIndex = 0;
		this.players = players;
		this.board = board;
	}

	public Player currentPlayer() {
		return this.players.get(currentIndex);
	}

	public void endPlayerTurn() {
		currentIndex++;
		currentIndex %= players.size();
	}
	
	public static Game getInstance(final int boardWidth, final int boardHeight) {
		if (instance == null) {
			Board board = new Board(SPOTS_QUANTITY);

			// initializing models
			List<Player> players = Arrays.asList(
					new Player("Player 0", PlayerColor.RED, SPOTS_QUANTITY),
					new Player("Player 1", PlayerColor.GREEN, SPOTS_QUANTITY),
					new Player("Player 2", PlayerColor.YELLOW, SPOTS_QUANTITY),
					new Player("Player 3", PlayerColor.BLUE, SPOTS_QUANTITY));		
			 
	    	instance = new Game(players, board);
		}

		return instance;
	}

	public List<Player> getPlayers() {
		return new ArrayList<Player>(players);
	}

	public Board getBoard() {
		return board;
	}

}
