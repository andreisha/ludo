package br.pucrio.poo.controllers;
import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.models.TokenPositionCalculator;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.domain.PlayerColor;
import br.pucrio.poo.utils.IObserver;
import br.pucrio.poo.models.BoardSpotsCalculations;
import br.pucrio.poo.models.Position;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.board.Token;
import br.pucrio.poo.views.board.TokenFactory;


public class BoardController {
	
	private static BoardController instance;
	
	private Game game;
	private TokenPositionCalculator tokenCalculator;
	private ColorController colorController;
	private TokenFactory tokenFactory;
	private BoardSpotsCalculations spotsCalculation;
	
	private BoardController(Game game, int width, int height) {
		this.game = game;
		this.colorController = new ColorController();
		this.spotsCalculation = new BoardSpotsCalculations(width, height);
		 this.tokenCalculator = new TokenPositionCalculator(spotsCalculation);
		 this.tokenFactory = new TokenFactory(width/30);
	}
	
	public static BoardController getInstance(Game game){
		if (instance == null) {			 
	    	instance = new BoardController(game, game.getBoardWidth(), game.getBoardHeight());
		}
		return instance;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void registerObserver(IObserver observer) {
		List<Player> players = this.game.getPlayers();
		for (Player player : players) {
			player.registerMoveObserver(observer);
		}
	}	

	public List<Token> getTokens() {
		ArrayList<Token> tokens = new ArrayList<Token>();

		for (int i = 0; i < this.game.getPlayers().size(); i++) {
			tokens.addAll(getTokenOfPlayer(i));
		}
		return tokens;
	}

	private ArrayList<Token> getTokenOfPlayer(int playerIndex) {
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		Player player = this.game.getPlayers().get(playerIndex);
		
		for (int relativeSpotNumber : player.getSpotNumbers()) {
			boolean enabled = player.getPinAtSpot(relativeSpotNumber).isEnabled();
			Position tokenPosition = tokenCalculator.getPositionOf(relativeSpotNumber, player.getColor());
			int spotNumber = tokenCalculator.getSpotNumberFromRelativeSpotNumber(relativeSpotNumber, player.getColor());
			Token token = tokenFactory.getToken(tokenPosition, colorController.getColorFromPlayerColor(player.getColor()), spotNumber, enabled);			
			tokens.add(token);
		}		
		return tokens;
	}
	
	public int getRelativeSpotNumberFromSpotNumber(int spotNumber, PlayerColor color) {
		return spotsCalculation.getRelativeSpotNumberFromSpotNumber(spotNumber, color);
	}
	
	public int getSpotNumberFromRelativeSpotNumber(int relativeSpotNumber, PlayerColor color) {
		return spotsCalculation.getSpotNumberFromRelativeSpotNumber(relativeSpotNumber, color);
	}	
}	