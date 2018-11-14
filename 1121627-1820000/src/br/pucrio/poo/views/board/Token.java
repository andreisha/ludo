package br.pucrio.poo.views.board;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Token {
	private int x;
	private int y;
	private Color color;
	private int radius;

	public Token(int x, int y, Color color, int radius) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.radius = radius;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void paintToken(Graphics2D graphics) {

		Ellipse2D token = new Ellipse2D.Double(this.getX(), this.getY(), radius, radius);
		graphics.setPaint(Color.BLACK);
		graphics.draw(token);
		graphics.setPaint(this.getColor());
		graphics.fill(token);
	}

}
