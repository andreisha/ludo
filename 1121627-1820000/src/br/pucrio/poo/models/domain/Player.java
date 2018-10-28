package br.pucrio.poo.models.domain;

import java.util.Observable;

public class Player extends Observable {

	private static final int MAX_CONTINUED_ROLL = 2;
	private final PlayerColor color;
	private int spotNumber;
	private final int spotsQuantity;
	private Dice diceOne;
	private Dice diceTwo;
	private int continuedRollCount = 0;
	private String name;

	public Player(String name, PlayerColor color, int spotsQuantity) {
		this.name = name;
		this.color = color;
		this.spotNumber = 0;
		this.spotsQuantity = spotsQuantity;
	}

	public void goForward(int steps) {
		this.spotNumber += steps;
		this.spotNumber %= spotsQuantity;
	}

	public PlayerColor getColor() {
		return this.color;
	}

	public int getSpotNumber() {
		return this.spotNumber;
	}

	public void rollDices() throws Exception {
		this.diceOne = Dice.roll();
		this.diceTwo = Dice.roll();
		if (canPlayAgain()) {
			continuedRollCount++;
		} else {
			continuedRollCount = 0;
		}
	}

	public int getDicePoints() {
		return this.diceOne.getValue() + this.diceTwo.getValue();
	}
	
	public int getDiceOneResult() {
		return diceOne.getValue();
	}
	
	public int getDiceTwoResult() {
		return diceTwo.getValue();
	}

	public Dice getDiceOne() {
		return diceOne;
	}

	public Dice getDiceTwo() {
		return diceTwo;
	}

	public boolean canPlayAgain() {
		return diceOne == diceTwo;
	}

	public boolean exceedContinuedRoll() {
		return continuedRollCount >= MAX_CONTINUED_ROLL;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}
}
