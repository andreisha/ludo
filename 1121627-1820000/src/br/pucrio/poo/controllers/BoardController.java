package br.pucrio.poo.controllers;
import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.models.TokenPositionCalculator;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.Position;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.board.Token;
import br.pucrio.poo.views.board.TokenFactory;


public class BoardController {
	private Game game;
	private TokenPositionCalculator tokenCalculator;
	private BoardPanel boardPanel;
	private ColorController colorController;
	private TokenFactory tokenFactory;
	
	public BoardController(Game game, TokenPositionCalculator tokenCalculator,BoardPanel boardPanel,
			ColorController colorController, TokenFactory tokenFactory ) {
		this.game = game;
		this.tokenCalculator = tokenCalculator;
		this.boardPanel = boardPanel;
		this.colorController = colorController;
		this.tokenFactory = tokenFactory;
	}

	public void update() {
		boardPanel.repaint(getTokens()); // implementar observable
	}

	private List<Token> getTokens() {
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
			Position tokenPosition = tokenCalculator.getPositionOf(relativeSpotNumber, player.getColor());
			int spotNumber = tokenCalculator.getSpotNumberFromRelativeSpotNumber(relativeSpotNumber, player.getColor());
			Token token = tokenFactory.getToken(tokenPosition, colorController.getColorFromPlayerColor(player.getColor()), spotNumber);			
			tokens.add(token);
		}		
		return tokens;
	}
	
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

}
