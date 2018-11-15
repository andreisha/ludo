package br.pucrio.poo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.Token;

public class BoardPanel extends JPanel {
	private BoardPainter painter;
	private List<Token> tokens;
	private List<Casa> casas;

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
	
	public void repaint(List<Token> tokens, List<Casa> casas) {
		this.tokens = tokens;
		this.casas = casas;
		this.repaint();
	}

	private void paintTokens(Graphics2D graphics, List<Casa> casas ) {
		
		
	
		/*for (Token token : this.tokens) {
			token.paintToken(graphics, x, y);
		}
		*/
		for (Casa casa: casas) {
			int x = (casa.getXMAX()+casa.getXMIN())/2 -7;
			int y = (casa.getYMAX()+casa.getYMIN())/2 -7;
			//if ((casa.getToken1().getColor() != Color.WHITE) | (casa.getToken2().getColor() != Color.WHITE)) {
				Token tokencasa = casa.getToken1();
				//tokencasa.paintToken(graphics, x, y);
			//}
				

		}
		
	}
}
