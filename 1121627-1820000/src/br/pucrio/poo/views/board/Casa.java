package br.pucrio.poo.views.board;

import java.awt.Color;

public class Casa {
	private int x;
	private int y;
	private int width;
	private int heigth;
	private Color color;

	public Casa(int x, int y, int width, int heigth, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = heigth;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}

	public Color getColor() {
		return color;
	}
}
