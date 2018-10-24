package br.pucrio.poo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.pucrio.poo.views.board.Token;

public class BoardPanel extends JPanel {
	private BoardPainter painter;
	private List<Token> tokens;

	public BoardPanel(BoardPainter painter, int width, int height) {
		this.painter = painter;
		this.tokens = new ArrayList<Token>();
		this.setPreferredSize(new Dimension(width, height));
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
		
		this.tokens.add(new Token(10, 10, Color.BLUE));
		this.tokens.add(new Token(10, 30, Color.BLUE));
		this.tokens.add(new Token(30, 10, Color.BLUE));
		this.tokens.add(new Token(30, 30, Color.BLUE));
		
		for (Token token : this.tokens) {
			painter.paintToken(graphics, token);
		}
	}
}
