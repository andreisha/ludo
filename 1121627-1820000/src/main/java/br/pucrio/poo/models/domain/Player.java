package br.pucrio.poo.models.domain;

public class Player {
	
	private String name;
	private final PlayerColor color;
	private Dice diceOne;
	private Dice diceTwo;
	
	public Player(String name, PlayerColor color) {
		this.name = name;
		this.color = color;
	}

}
