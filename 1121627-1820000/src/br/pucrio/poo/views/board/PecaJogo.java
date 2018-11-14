package br.pucrio.poo.views.board;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class PecaJogo {
	private int x_min;
	private int x_max;
	private int y_min;
	private int y_max;
	private Color color1;
	private Color color2;
	private int radius;

	public PecaJogo(int x_min,int x_max, int y_min, int y_max, Color color1, Color color2, int radius) {
		this.x_min = x_min;
		this.x_max = x_max;
		this.y_min = y_min;
		this.y_max = y_max;
		this.color1 = color1;
		this.color2 = color2;
		this.radius = radius;
	}
	
	public int getXMIN() {
		return x_min;
	}
	
	public int getXMAX() {
		return x_max;
	}

	public int getYMIN() {
		return y_min;
	}

	public int getYMAX() {
		return y_max;
	}

	public Color getColor1() {
		return color1;
	}
	
	public Color getColor2() {
		return color2;
	}
	
	public int getRadius() {
		return radius;
	}

	public void paintPecaJogo(Graphics2D graphics) {
		
		int x = (this.getXMAX()+this.getXMIN())/2;
		int y = (this.getYMAX()+this.getYMIN())/2;

		Ellipse2D token = new Ellipse2D.Double(x, y, radius, radius);
		graphics.setPaint(Color.BLACK);
		graphics.draw(token);
		graphics.setPaint(this.getColor1());
		graphics.fill(token);
	}
}