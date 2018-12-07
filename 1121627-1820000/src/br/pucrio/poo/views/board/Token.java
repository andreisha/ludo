package br.pucrio.poo.views.board;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Token {
	private int x;
	private int y;
	private Color color;
	private int radius;
	private final int spotNumber;
	private boolean enabled;

	public Token(int x, int y, Color color, int radius, int spotNumber, boolean enabled) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.radius = radius;
		this.spotNumber = spotNumber;
		this.enabled = enabled;
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
	
	public int getSpotNumber() {
		return spotNumber;
	}	
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void paintToken(Graphics2D graphics) {

		Ellipse2D token = new Ellipse2D.Double(x + 1.5*radius/4, y+ 1.5*radius/4, radius*1.2, radius*1.2);
		graphics.setPaint(Color.BLACK);
		graphics.draw(token);
		graphics.setPaint(this.getColor());
		graphics.fill(token);
	}
	public void paintTokenDouble(Graphics2D graphics, boolean sameColor) {

		if (sameColor == true) {
			Ellipse2D token = new Ellipse2D.Double(x + radius/8, y+ radius/8, radius*7/4, radius*7/4);
			graphics.setPaint(this.getColor());
			graphics.draw(token);
		}
		else {
			Ellipse2D token = new Ellipse2D.Double(x + 2.2*radius/4, y+ 2.2*radius/4, radius*0.8, radius*0.8);
			graphics.setPaint(Color.BLACK);
			graphics.draw(token);
			graphics.setPaint(this.getColor());
			graphics.fill(token);
		}
	}
}
