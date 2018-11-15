package br.pucrio.poo.models.domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.pucrio.poo.views.board.Casa;

public class Game {

	private static final int SPOTS_QUANTITY = 52;

	private static List<Casa> casas = new ArrayList<Casa>();;

	
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

	public List<Casa> getCasas(){
		return casas;
	}
	
	public static Game getInstance(final int boardWidth, final int boardHeight) {
		if (instance == null) {
			Board board = new Board(SPOTS_QUANTITY);

			// initializing models
			List<Player> players = Arrays.asList(new Player("Player 0", PlayerColor.RED, board.getSpotsQuantity(), 1),
					new Player("Player 1", PlayerColor.GREEN, board.getSpotsQuantity(), 14),
					new Player("Player 2", PlayerColor.YELLOW, board.getSpotsQuantity(), 27),
					new Player("Player 3", PlayerColor.BLUE, board.getSpotsQuantity(), 40));
		
			casas.add(new Casa(0,boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 0, players.get(0).getToken1(), null));
			casas.add(new Casa(boardWidth / 15, 2*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.RED, true, boardWidth/15, boardHeight/15, false, 1, players.get(0).getToken1(), null));
			casas.add(new Casa(2*boardWidth / 15, 3*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 2, null, null));
			casas.add(new Casa(3*boardWidth / 15, 4*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 3, null, null));
			casas.add(new Casa(4*boardWidth / 15, 5*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 4, null, null));
			casas.add(new Casa(5*boardWidth / 15, 6*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 5, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 5 * boardHeight / 15, 6* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 6, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 4 * boardHeight / 15, 5* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 7, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 3 * boardHeight / 15, 4* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 8, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 2 * boardHeight / 15, 3* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 9, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 1 * boardHeight / 15, 2* boardHeight / 15, Color.BLACK, false, boardWidth/15, boardHeight/15, false, 10, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 0, boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 11, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth / 15, 0, boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 12, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 0, boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 13, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, boardHeight / 15, 2* boardHeight / 15, Color.GREEN, true, boardWidth/15, boardHeight/15, false, 14, players.get(1).getToken1(), null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 2* boardHeight / 15, 3* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 15, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 3* boardHeight / 15, 4* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 16, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 4* boardHeight / 15, 5* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 17, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 5* boardHeight / 15, 6* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 18, null, null));
			casas.add(new Casa(9*boardWidth / 15, 10*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 19, null, null));
			casas.add(new Casa(10*boardWidth / 15, 11*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 20, null, null));
			casas.add(new Casa(11*boardWidth / 15, 12*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 21, null, null));
			casas.add(new Casa(12*boardWidth / 15, 13*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 22, null, null));
			casas.add(new Casa(13*boardWidth / 15, 14*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.BLACK, false, boardWidth/15, boardHeight/15, false, 23, null, null));
			casas.add(new Casa(14*boardWidth / 15, boardWidth, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 24, null, null));
			casas.add(new Casa(14*boardWidth / 15, boardWidth, 7* boardHeight / 15, 8* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 25, null, null));
			casas.add(new Casa(14*boardWidth / 15, boardWidth, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 26, null, null));
			casas.add(new Casa(13*boardWidth / 15, 14*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.YELLOW, true, boardWidth/15, boardHeight/15, false, 27, players.get(2).getToken1(), null));
			casas.add(new Casa(12*boardWidth / 15, 13*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 28, null, null));
			casas.add(new Casa(11*boardWidth / 15, 12*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 29, null, null));
			casas.add(new Casa(10*boardWidth / 15, 11*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 30, null, null));
			casas.add(new Casa(9*boardWidth / 15, 10*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 31, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 9* boardHeight / 15, 10* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 32, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 10* boardHeight / 15, 11* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 33, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 11* boardHeight / 15, 12* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 34, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 12* boardHeight / 15, 13* boardHeight / 15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 35, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 13* boardHeight / 15, 14* boardHeight / 15, Color.BLACK, false, boardWidth/15, boardHeight/15, false, 36, null, null));
			casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 14* boardHeight / 15, boardHeight, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 37, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth/ 15, 14* boardHeight / 15, boardHeight, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 38, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 14* boardHeight / 15, boardHeight, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 39, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 13* boardHeight / 15, 14* boardHeight /15, Color.BLUE, true, boardWidth/15, boardHeight/15, false, 40, players.get(3).getToken1(), null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 12* boardHeight / 15, 13* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 41, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 11* boardHeight / 15, 12* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 42, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 10* boardHeight / 15, 11* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 43, null, null));
			casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 9* boardHeight / 15, 10* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 44, null, null));
			casas.add(new Casa(5*boardWidth / 15, 6*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 45, null, null));
			casas.add(new Casa(4*boardWidth / 15, 5*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 46, null, null));
			casas.add(new Casa(3*boardWidth / 15, 4*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 47, null, null));
			casas.add(new Casa(2*boardWidth / 15, 3*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 48, null, null));
			casas.add(new Casa(boardWidth / 15, 2*boardWidth, 8* boardHeight / 15, 9* boardHeight /15, Color.BLACK, false, boardWidth/15, boardHeight/15, false, 49, null, null));
			casas.add(new Casa(0, boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 50, null, null));
			casas.add(new Casa(0, boardWidth/ 15, 7* boardHeight / 15, 8* boardHeight /15, Color.WHITE, false, boardWidth/15, boardHeight/15, false, 51, null, null));
		//finais vermelhas
			casas.add(new Casa(boardWidth / 15, 2*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, boardWidth/15, boardHeight/15, true, 52, null, null));
			casas.add(new Casa(2*boardWidth / 15, 3*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, boardWidth/15, boardHeight/15, true, 53, null, null));
			casas.add(new Casa(3*boardWidth / 15, 4*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, boardWidth/15, boardHeight/15, true, 54, null, null));
			casas.add(new Casa(4*boardWidth / 15, 5*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, boardWidth/15, boardHeight/15, true, 55, null, null));
			casas.add(new Casa(5*boardWidth / 15, 6*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, boardWidth/15, boardHeight/15, true, 56, null, null));
		//finais verdes
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, boardHeight / 15, 2* boardHeight /15, Color.GREEN, false, boardWidth/15, boardHeight/15, true, 57, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 2*boardHeight / 15, 3* boardHeight /15, Color.GREEN, false, boardWidth/15, boardHeight/15, true, 58, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 3*boardHeight / 15, 4* boardHeight /15, Color.GREEN, false, boardWidth/15, boardHeight/15, true, 59, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 4*boardHeight / 15, 5* boardHeight /15, Color.GREEN, false, boardWidth/15, boardHeight/15, true, 60, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 5*boardHeight / 15, 6* boardHeight /15, Color.GREEN, false, boardWidth/15, boardHeight/15, true, 61, null, null));
			//finais amarelas
			casas.add(new Casa(13*boardWidth / 15, 14*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, boardWidth/15, boardHeight/15, true, 62, null, null));
			casas.add(new Casa(12*boardWidth / 15, 13*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, boardWidth/15, boardHeight/15, true, 63, null, null));
			casas.add(new Casa(11*boardWidth / 15, 12*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, boardWidth/15, boardHeight/15, true, 64, null, null));
			casas.add(new Casa(10*boardWidth / 15, 11*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, boardWidth/15, boardHeight/15, true, 65, null, null));
			casas.add(new Casa(9*boardWidth / 15, 10*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, boardWidth/15, boardHeight/15, true, 66, null, null));		
			//finais verdes
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 13*boardHeight / 15, 14* boardHeight /15, Color.BLUE, false, boardWidth/15, boardHeight/15, true, 67, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 12*boardHeight / 15, 13* boardHeight /15, Color.BLUE, false, boardWidth/15, boardHeight/15, true, 68, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 11*boardHeight / 15, 12* boardHeight /15, Color.BLUE, false, boardWidth/15, boardHeight/15, true, 69, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 10*boardHeight / 15, 11* boardHeight /15, Color.BLUE, false, boardWidth/15, boardHeight/15, true, 70, null, null));
			casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 9*boardHeight / 15, 10* boardHeight /15, Color.BLUE, false, boardWidth/15, boardHeight/15, true, 71, null, null));
		
			//casas iniciais
			casas.add(new Casa(boardWidth / 15, 2*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.RED, false, boardWidth/15, boardHeight/15, false, 72, null, null));
			casas.add(new Casa(4*boardWidth / 15, 5*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.RED, false, boardWidth/15, boardHeight/15, false, 73, players.get(0).getToken2(), null));
			casas.add(new Casa(boardWidth / 15, 2*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.RED, false, boardWidth/15, boardHeight/15, false, 74, players.get(0).getToken3(), null));
			casas.add(new Casa(4*boardWidth / 15, 5*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.RED, false, boardWidth/15, boardHeight/15, false, 75, players.get(0).getToken4(), null));

			casas.add(new Casa(10*boardWidth / 15, 11*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.GREEN, false, boardWidth/15, boardHeight/15, false, 76, null, null));
			casas.add(new Casa(13*boardWidth / 15, 14*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.GREEN, false, boardWidth/15, boardHeight/15, false, 77, players.get(1).getToken2(), null));
			casas.add(new Casa(10*boardWidth / 15, 11*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.GREEN, false, boardWidth/15, boardHeight/15, false, 78, players.get(1).getToken3(), null));
			casas.add(new Casa(13*boardWidth / 15, 14*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.GREEN, false, boardWidth/15, boardHeight/15, false, 79, players.get(1).getToken4(), null));

			casas.add(new Casa(10*boardWidth / 15, 11*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.YELLOW, false, boardWidth/15, boardHeight/15, false, 80, null, null));
			casas.add(new Casa(13*boardWidth / 15, 14*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.YELLOW, false, boardWidth/15, boardHeight/15, false, 81, players.get(2).getToken2(), null));
			casas.add(new Casa(10*boardWidth / 15, 11*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.YELLOW, false, boardWidth/15, boardHeight/15, false, 82, players.get(2).getToken3(), null));
			casas.add(new Casa(13*boardWidth / 15, 14*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.YELLOW, false, boardWidth/15, boardHeight/15, false, 83, players.get(2).getToken4(), null));

			casas.add(new Casa(boardWidth / 15, 2*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.BLUE, false, boardWidth/15, boardHeight/15, false, 84, null, null));
			casas.add(new Casa(4*boardWidth / 15, 5*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.BLUE, false, boardWidth/15, boardHeight/15, false, 85, players.get(3).getToken2(), null));
			casas.add(new Casa(boardWidth / 15, 2*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.BLUE, false, boardWidth/15, boardHeight/15, false, 86, players.get(3).getToken3(), null));
			casas.add(new Casa(4*boardWidth / 15, 5*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.BLUE, false, boardWidth/15, boardHeight/15, false, 87, players.get(3).getToken4(), null));

			
			
			
			
			
			
			
			
			
			
			
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
