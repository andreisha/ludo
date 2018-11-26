package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.List;
import br.pucrio.poo.utils.IObservable;
import br.pucrio.poo.utils.IObserver;


public class Player implements IObservable{

	private static final int MAX_CONTINUED_ROLL = 2;
	private static final int MUST_LEAVE_STEPS = 5;
	private final PlayerColor color;
	private Dice dice;
	private int continuedRollCount = 0;
	private String name;
	private List<Pin> pins;	
	private List<IObserver> observers = new ArrayList<IObserver>();

	public Player(String name, PlayerColor color, int spotsQuantity) {
		this.name = name;
		this.color = color;
		PinFactory pinFactory = new PinFactory(spotsQuantity);
		this.pins = pinFactory.getPin(color);
		this.dice = Dice.roll();
	}

	public void goForward(int spotNumber) {
		Pin pin = getPinAtSpot(spotNumber);		
		if(pin==null)
			return;		
		int steps = getDicePoints();		
		pin.goForward(steps);
		notifyObservers();
	}
	
	private Pin getPinAtSpot(int spotNumber) {
		for (Pin pin : pins) {
			if(pin.getSpotNumber() == spotNumber)
				return pin;
		}
		return null;
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

	public void rollDices(){
		this.dice = Dice.roll();
		
		if(shouldLeaveHome())
			leaveHome();
		
		if (canPlayAgain()) {
			continuedRollCount++;
		} else {
			continuedRollCount = 0;
		}
		notifyObservers();
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
		return dice.getValue() == 6 && !exceedContinuedRoll();
	}
	
	public boolean isInitialSpotBloqued() {
		int pinsAtInitialSpot = 0;
		
		for (Pin pin : pins) {
			if(pin.isAtInitialSpot())
				pinsAtInitialSpot++;
		}
		
		if(pinsAtInitialSpot > 1)
			return true;
		
		return false;
	}
	
	public boolean anyPinAtHome() {
		for (Pin pin : pins) {
			if(pin.isAtHome())
				return true;
		}
		return false;
	}
	
	public Pin getPinAtHome() {
		for (Pin pin : pins) {
			if(pin.isAtHome())
				return pin;
		}
		return null;
	}
	
	public boolean shouldLeaveHome() {
		return getDicePoints() == MUST_LEAVE_STEPS && anyPinAtHome() && !isInitialSpotBloqued();
	}
	
	public void leaveHome() {		
		if(shouldLeaveHome()) {
			Pin pinAtHome = getPinAtHome();
			pinAtHome.leaveHome();
		}
	}
	
	public boolean canMove(int spotNumber) {
		Pin pin = getPinAtSpot(spotNumber);
		
		if(pin==null)
			return false;
		
		return true;
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

	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		for (IObserver observer : observers) {
			observer.updateView(this);
            }		
	}
}
