package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;


public class Player extends Observable {

	private static final int MAX_CONTINUED_ROLL = 2;
	private final PlayerColor color;
	private Dice dice;
	private int continuedRollCount = 0;
	private String name;
	private List<Pin> pins;	

	public Player(String name, PlayerColor color, int spotsQuantity) {
		this.name = name;
		this.color = color;
		PinFactory pinFactory = new PinFactory(spotsQuantity);
		this.pins = pinFactory.getPin(color);
	}

	public void goForward(int steps, int spotNumber) {
		for (Pin pin : pins) {
			if(pin.getSpotNumber() == spotNumber) {				
				pin.goForward(steps);
				return;// move apenas o primeiro que achar na casa spotNumber
			}
		}		
	}
	
	public List<Integer> getSpotNumbers() {
		List<Integer> spotNumbers = new ArrayList<Integer>();
		for (Pin pin : pins) {
			spotNumbers.add(pin.getSpotNumber());
		}
		return spotNumbers;
	}

	public PlayerColor getColor() {
		return this.color;
	}

	public void rollDices() throws Exception {
		this.dice = Dice.roll();
		if (canPlayAgain()) {
			continuedRollCount++;
		} else {
			continuedRollCount = 0;
		}
	}

	public int getDicePoints() {
		return this.dice.getValue();
	}
	
	public int getDiceResult() {
		return dice.getValue();
	}	

	public Dice getDice() {
		return dice;
	}

	public boolean canPlayAgain() {
		return dice.getValue() == 6 ;
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
