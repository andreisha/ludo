package br.pucrio.poo.models.domain;

import java.util.List;
import java.util.Observable;

import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.Token;

import java.awt.Color;


public class Player extends Observable {

	private static final int MAX_CONTINUED_ROLL = 2;
	private final PlayerColor color;
	//private final Color color;
	private int spotNumberIni;
	private int spotNumber = 1;
	private final int spotsQuantity;
	private Dice diceOne;
	private int continuedRollCount = 0;
	private String name;
	private Token token1;
	private Token token2;
	private Token token3;
	private Token token4;
	
	

	public Player(String name, PlayerColor color, int spotsQuantity, int spotNumber) {
		this.name = name;
		this.color = color;
		this.spotNumberIni = spotNumber;
		//this.spotNumber = spotNumber;
		this.spotsQuantity = spotsQuantity;
	}

	public void goForward(int steps, List<Casa> casas) {
		casas.get(this.spotNumber).modifyColorToken1(Color.WHITE);
		this.spotNumber += steps;
		//this.spotNumber %= spotsQuantity;
		casas.get(this.spotNumber).modifyColorToken1(Color.RED);
	}

	public PlayerColor getColor() {
		return this.color;
	}

	public int getSpotNumber() {
		return this.spotNumber;
	}

	public void rollDices() throws Exception {
		this.diceOne = Dice.roll();
		if (canPlayAgain()) {
			continuedRollCount++;
		} else {
			continuedRollCount = 0;
		}
	}

	public int getDicePoints() {
		return this.diceOne.getValue();
	}
	
	public int getDiceOneResult() {
		return diceOne.getValue();
	}
	

	public Dice getDiceOne() {
		return diceOne;
	}

	public boolean canPlayAgain() {
		return diceOne.getValue() == 6 ;
	}

	public boolean exceedContinuedRoll() {
		return continuedRollCount >= MAX_CONTINUED_ROLL;
	}

	
	public Token getToken1() {
		return token1;
	}
	
	public Token getToken2() {
		return token2;
	}
	
	public Token getToken3() {
		return token3;
	}
	
	public Token getToken4() {
		return token4;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}
}
