package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

	private static final int SPOTS_QUANTITY = 40;

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

	public static Game getInstance() {
		if (instance == null) {
			Board board = new Board(SPOTS_QUANTITY);

			// initializing models
			List<Player> players = Arrays.asList(new Player("Player 1", PlayerColor.BLUE, board.getSpotsQuantity()),
					new Player("Player 2", PlayerColor.RED, board.getSpotsQuantity()),
					new Player("Player 3", PlayerColor.GREEN, board.getSpotsQuantity()),
					new Player("Player 4", PlayerColor.YELLOW, board.getSpotsQuantity()));

			instance = new Game(players, board);
		}

		return instance;
	}

	public List<Player> getPlayers() {
		return new ArrayList<Player>(players);
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
