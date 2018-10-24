package br.pucrio.poo.views;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import br.pucrio.poo.views.board.Token;

public class BoardPainter {
	private int boardWidth;
	private int boardHeight;
	private int tokenRadius;

	public BoardPainter(int boardWidth, int boardHeight, int tokenRadius) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.tokenRadius = tokenRadius;
	}

	public void paintBoard(Graphics2D graphics) {
		// código de desenho do tabuleiro
		graphics.drawString("Desenho do tabuleiro aqui",boardWidth/2,boardHeight/2);
	}

	public void paintToken(Graphics2D graphics, Token token) {
		
		// codigo de desenho das peças do jogo		
		double radius = 10;		
		Ellipse2D circ=new Ellipse2D.Double(token.getX(),token.getY(),tokenRadius,tokenRadius);
		graphics.setPaint(token.getColor());
		graphics.fill(circ);
	}
}
