package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.utils.IMoveObservable;
import br.pucrio.poo.utils.IMoveObserver;
import br.pucrio.poo.utils.IObservable;
import br.pucrio.poo.utils.IObserver;
import br.pucrio.poo.utils.IResultObservable;
import br.pucrio.poo.utils.IResultObserver;


public class Player implements IMoveObservable, IResultObservable{

	private static final int MAX_CONTINUED_ROLL = 2;
	private static final int MUST_LEAVE_STEPS = 5;
	private final PlayerColor color;
	private Dice dice;
	private int continuedRollCount = 0;
	private String name;
	private List<Pin> pins;	
	private List<IMoveObserver> moveObservers = new ArrayList<IMoveObserver>();
	private List<IResultObserver> resultObservers = new ArrayList<IResultObserver>();

	public Player(String name, PlayerColor color, int spotsQuantity) throws Exception {
		this.name = name;
		this.color = color;
		PinFactory pinFactory = new PinFactory(spotsQuantity);
		this.pins = pinFactory.getPin(color);
		//this.dice = new Dice(ONE);
		this.pins.get(0).goForward(1);
	}

	public void goForward(int spotNumber) {
		Pin pin = getPinAtSpot(spotNumber);		
		if(pin==null)
			return;		
		int steps = getDicePoints();		
		pin.goForward(steps);
		notifyMoveObservers();
	}
	
	public void go20Forward(int spotNumber) {
		Pin pin = getPinAtSpot(spotNumber);		
		if(pin==null)
			return;		
		int steps = 20;		
		pin.goForward(steps);
		notifyMoveObservers();
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

	public void rollDices() throws Exception{
		this.dice = this.dice.roll();
		
		if(shouldLeaveHome())
			leaveHome();
		
		if (canPlayAgain()) {
			continuedRollCount++;
		} else {
			continuedRollCount = 0;
		}
		notifyResultObservers();
	}
	public void rollDices(int numero) throws Exception{
		this.dice = this.dice.roll(numero);
		
		if(shouldLeaveHome())
			leaveHome();
		
		if (canPlayAgain()) {
			continuedRollCount++;
		} else {
			continuedRollCount = 0;
		}
		notifyResultObservers();
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
		return (getDicePoints() == MUST_LEAVE_STEPS) && anyPinAtHome() && !isInitialSpotBloqued();
	}
	
	public void leaveHome() {		
		if(shouldLeaveHome()) {
			Pin pinAtHome = getPinAtHome();
			pinAtHome.leaveHome();
			notifyMoveObservers();
		}
	}
	
	public boolean isHomeSpot(int spotNumber) {
		return spotNumber < 0;
	}
	
	public boolean canMove(int spotNumber) {
		Pin pin = getPinAtSpot(spotNumber);
		
		if(pin==null)
			return false;
		
		boolean isAtHome = pin.isAtHome();
		int steps = getDicePoints();
		boolean isInitialSpotBloqued = isInitialSpotBloqued();
		if(isAtHome && (steps != MUST_LEAVE_STEPS || isInitialSpotBloqued))
			return false;
		if (pin.getSpotNumber() + steps > 56 ) return false;
		
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
	public void registerMoveObserver(IObserver observer) {
		moveObservers.add((IMoveObserver)observer);		
	}

	@Override
	public void removeMoveObserver(IObserver observer) {
		moveObservers.remove(observer);		
	}

	@Override
	public void notifyMoveObservers() {
		for (IMoveObserver observer : moveObservers) {
			observer.updateView(this);
		}
	}

	@Override
	public void registerResultObserver(IObserver observer) {
		resultObservers.add((IResultObserver)observer);		
	}

	@Override
	public void removeResultObserver(IObserver observer) {
		resultObservers.remove(observer);		
	}

	@Override
	public void notifyResultObservers() {
		for (IResultObserver observer : resultObservers) {
			observer.updateView(this);
		}
	}
}