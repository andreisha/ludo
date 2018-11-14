package br.pucrio.poo.views.board;

import java.awt.Color;
import java.awt.Graphics2D;

public class Reta {
	private int x[];
	private int y[];
	private Color color;

	public Reta(int x[], int y[], Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int[] getX() {
		return x;
	}

	public int[] getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
	public void paintReta(Graphics2D graphics) {

		// codigo de desenho das casas do jogo
		graphics.setPaint(Color.BLACK);
		graphics.drawPolygon(this.getX(), this.getY(), 3);
		graphics.setPaint(this.getColor());
		graphics.fillPolygon(this.getX(), this.getY(), 3);
	}
}
