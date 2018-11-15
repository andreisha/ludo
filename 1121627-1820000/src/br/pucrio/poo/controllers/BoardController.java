package br.pucrio.poo.controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.models.TokenPositionCalculator;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.Position;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.Token;
import br.pucrio.poo.controllers.NewGameController;


public class BoardController {
	private List<Player> players;
	private TokenPositionCalculator tokenCalculator;
	private BoardPanel boardPanel;
	private ColorController colorController;
	private MouseListener mouseListener;
	//private PlayerWalkController playerWalkController;
	private List<Casa> casas;
	
	public BoardController(List<Player> players, TokenPositionCalculator tokenCalculator, BoardPanel boardPanel,
			ColorController colorController, List<Casa> casas ) {
		this.players = players;
		this.tokenCalculator = tokenCalculator;
		this.boardPanel = boardPanel;
		this.colorController = colorController;
		//this.playerWalkController = playerWalkController;
		this.casas = casas;
	}

	public void update(List<Casa> casas) {
		boardPanel.repaint(getTokens(), casas);
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
		Token token = new Token(x, y, colorController.getColorFromPlayerColor(player.getColor()), 15, 0);
		return token;
	}
	
	public void getMouseClic(PlayerWalkController playerWalkController, Player player, int steps) {
		
		this.mouseListener = new MouseAdapter() {			
			public void mouseClicked(MouseEvent e) {
				int x=e.getX();
			    int y=e.getY();
			  //System.out.println(x+","+y);
			    Casa casaclic = null;
			    
			    for (Casa casa: casas) {
			    	if ((x<=casa.getXMAX()) & (x>= casa.getXMIN()) & (y <=casa.getYMAX()) & (y>=casa.getYMIN())) {
			    		casaclic = casa;
			    	}
			    }
			   
			    
			    if ((casaclic.getColor() == Color.WHITE) ) { //  or =>  | (casaclic.getColor1() == player.getColor())
					//casaclic.modifyColor1(player.getColor());
			    	playerWalkController.playerWalkOk(player, casas);
			    	
					
			    }
			   // elseif 
			    
			}
		};
		
		boardPanel.addMouseListener(mouseListener);
		
	}
	
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

}
