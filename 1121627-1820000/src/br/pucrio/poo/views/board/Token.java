package br.pucrio.poo.views.board;

import java.awt.Color;

public class Token {
	private int x;
	private int y;
	private Color color;

	public Token(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
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

}
