package br.pucrio.poo.controllers;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.models.TokenPositionCalculator;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.Position;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.board.Token;

public class BoardController {
	private List<Player> players;
	private TokenPositionCalculator tokenCalculator;
	private BoardPanel boardPanel;
	private ColorController colorController;

	public BoardController(List<Player> players, TokenPositionCalculator tokenCalculator, BoardPanel boardPanel,
			ColorController colorController) {
		this.players = players;
		this.tokenCalculator = tokenCalculator;
		this.boardPanel = boardPanel;
		this.colorController = colorController;
	}

	public void update() {
		boardPanel.repaint(getTokens());
	}

	private List<Token> getTokens() {
		ArrayList<Token> tokens = new ArrayList<Token>();

		for (int i = 0; i < this.players.size(); i++) {
			tokens.add(getTokenOfPlayer(i));
		}
		return tokens;
	}

	private Token getTokenOfPlayer(int i) {
		Player player = this.players.get(i);
		Position tokenPosition = tokenCalculator.getPositionOf(player.getSpotNumber(), i);

		int x = tokenPosition.getRoundedX();
		int y = tokenPosition.getRoundedY();
		Token pin = new Token(x, y, colorController.getColorFromPlayerColor(player.getColor()));
		return pin;
	}

}
