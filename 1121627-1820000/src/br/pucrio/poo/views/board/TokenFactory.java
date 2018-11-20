package br.pucrio.poo.views.board;

import java.awt.Color;

import br.pucrio.poo.models.Position;

public class TokenFactory {
	private int radius;
	
	public TokenFactory(int radius) {
		this.radius = radius;
	}
	
	
	public Token getToken(Position position, Color color, int spotNumber){
		return new Token(position.getRoundedX(),position.getRoundedY(),color,radius,spotNumber);
	}
	

}
