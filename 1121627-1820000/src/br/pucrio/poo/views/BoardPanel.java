package br.pucrio.poo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import br.pucrio.poo.controllers.ColorController;
import br.pucrio.poo.controllers.PlayerWalkController;
import br.pucrio.poo.models.TokenPositionCalculator;
import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.Token;

public class BoardPanel extends JPanel {
	private BoardPainter painter;
	private List<Token> tokens;
	private MouseListener mouseListener;

	public BoardPanel(BoardPainter painter, int width, int height, TokenPositionCalculator tokenCalculator) {
		this.painter = painter;
		this.tokens = new ArrayList<Token>();
		this.setPreferredSize(new Dimension(width, height));
		ColorController colorController = new ColorController();
		PlayerWalkController playerWalkController;
		
       this.mouseListener = new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int x=e.getX();
			    int y=e.getY();
			    
			    for (Casa casa: painter.getCasas()) {
			    	if ( x >= casa.getXMIN() && x <= casa.getXMAX() && y >= casa.getYMIN() && y <= casa.getYMAX()) {			    		
			    		for (Token token : tokens) {
			    			if(token.getSpotNumber() == casa.getNum()) {
			    				//playerWalkController.playerWalk(colorController.getPlayerColorFromColor(token.getColor()),token.getSpotNumber());
			    			}
						}
			    	}
			    }		    
			}
		};		
		this.addMouseListener(mouseListener);	
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
}
