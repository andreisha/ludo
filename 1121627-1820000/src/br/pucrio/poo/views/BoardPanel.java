package br.pucrio.poo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.pucrio.poo.views.board.CasaJogo;
import br.pucrio.poo.views.board.Token;

public class BoardPanel extends JPanel {
	private BoardPainter painter;
	private List<Token> tokens;
	private List<CasaJogo> casas;

	public BoardPanel(BoardPainter painter, int width, int height) {
		this.painter = painter;
		this.tokens = new ArrayList<Token>();
		this.setPreferredSize(new Dimension(width, height));
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		painter.paintBoard((Graphics2D) graphics);
		paintTokens((Graphics2D) graphics, this.casas);
		
	}

	/*public void repaint(List<Token> tokens) {
		this.tokens = tokens;
		this.repaint();
	}*/
	
	public void repaint(List<Token> tokens, List<CasaJogo> casas) {
		this.tokens = tokens;
		this.casas = casas;
		this.repaint();
	}

	private void paintTokens(Graphics2D graphics, List<CasaJogo> casas ) {
		
		
	/*	this.tokens.add(new Token(10, 30, Color.WHITE, 15));
		this.tokens.add(new Token(20, 30, Color.BLUE, 15));
		this.tokens.add(new Token(30, 10, Color.BLUE, 15));
		this.tokens.add(new Token(30, 30, Color.BLUE, 15));
*/
		for (Token token : this.tokens) {
			token.paintToken(graphics);
		}
		
		for (CasaJogo casa: casas) {
			int x = (casa.getXMAX()+casa.getXMIN())/2 -7;
			int y = (casa.getYMAX()+casa.getYMIN())/2 -7;
			if ((casa.getColor1() != Color.WHITE) | (casa.getColor2() != Color.WHITE)) {
				Token tokencasa = new Token(x, y, casa.getColor1(), 15);
				tokencasa.paintToken(graphics);
			}
				

		}
		
	}
}
