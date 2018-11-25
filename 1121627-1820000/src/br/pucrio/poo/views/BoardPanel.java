package br.pucrio.poo.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.pucrio.poo.controllers.BoardController;
import br.pucrio.poo.controllers.ColorController;
import br.pucrio.poo.controllers.PlayerWalkController;
import br.pucrio.poo.utils.IObserver;
import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.Token;

public class BoardPanel extends JPanel implements IObserver {
	private BoardPainter painter;
	private List<Token> tokens;
	private MouseListener mouseListener;
	private BoardController boardController;
	private PlayerWalkController playerWalkController;

	public BoardPanel(BoardPainter painter, int width, int height, BoardController boardController,PlayerWalkController playerWalkController) {
		this.painter = painter;
		this.tokens = new ArrayList<Token>();
		this.setPreferredSize(new Dimension(width, height));
		ColorController colorController = new ColorController();
		this.playerWalkController = playerWalkController;
		this.boardController = boardController;
		boardController.registerObserver(this);
		
       this.mouseListener = new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int x=e.getX();
			    int y=e.getY();
			    
			    for (Casa casa: painter.getCasas()) {
			    	if ( x >= casa.getXMIN() && x <= casa.getXMAX() && y >= casa.getYMIN() && y <= casa.getYMAX()) {			    		
			    		for (Token token : tokens) {
			    			if(token.getSpotNumber() == casa.getNum()) {
			    				playerWalkController.playerWalk(colorController.getPlayerColorFromColor(token.getColor()),token.getSpotNumber());
			    			}
						}
			    	}
			    }		    
			}
		};		
		this.addMouseListener(mouseListener);
		updateView(null);
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		painter.paintBoard((Graphics2D) graphics);
		paintTokens((Graphics2D) graphics);

	}

	public void repaint(List<Token> tokens) {
		this.tokens = tokens;
		this.repaint();
	}

	private void paintTokens(Graphics2D graphics) {
		for (Token token : tokens) {
			token.paintToken(graphics);
		}
	}

	@Override
	public void updateView(Object obj) {
		List<Token> tokens = boardController.getTokens();
		repaint(tokens);		
	}
}
