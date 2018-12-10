package br.pucrio.poo.models.domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import br.pucrio.poo.utils.IEnableToObservable;
import br.pucrio.poo.utils.IEnableToObserver;
import br.pucrio.poo.utils.IMoveObservable;
import br.pucrio.poo.utils.IMoveObserver;
import br.pucrio.poo.utils.IObserver;
import br.pucrio.poo.utils.IResultObservable;
import br.pucrio.poo.utils.IResultObserver;


public class Player implements IMoveObservable, IResultObservable, IEnableToObservable{

	private static final int MAX_CONTINUED_ROLL = 3;
	private static final int MUST_LEAVE_STEPS = 5;
	private static final int LAST_SPOT_NUMBER = 56;
	@Expose private final PlayerColor color;
	@Expose private Dice dice;
	@Expose private int continuedRollCount = 0;
	@Expose private String name;
	@Expose private List<Pin> pins;	
	private List<IMoveObserver> moveObservers = new ArrayList<IMoveObserver>();
	private List<IResultObserver> resultObservers = new ArrayList<IResultObserver>();
	private List<IEnableToObserver> enableToObservers = new ArrayList<IEnableToObserver>();
	@Expose private Pin lastPinPlayed;
	@Expose private int numberPlayerSucceed = 0;

	
	
	public Player(String name, PlayerColor color, int spotsQuantity){
		this.name = name;
		this.color = color;
		PinFactory pinFactory = new PinFactory(spotsQuantity);
		this.pins = pinFactory.getPin(color);
		this.pins.get(0).goForward(1);
		this.dice = new Dice();
		if (color == PlayerColor.RED) {
			this.pins.get(1).goForward(1);
			this.pins.get(0).goForward(1);
			this.pins.get(0).goForward(48);
			this.pins.get(1).goForward(49);
			this.pins.get(2).goForward(1);
			this.pins.get(3).goForward(1);

			this.pins.get(2).goForward(50);
			this.pins.get(3).goForward(52);

		}
	}

	
	public void goForward(int spotNumber) {
		Pin pin = getPinAtSpot(spotNumber);		
		if(pin==null)
			return;		
		int steps = getDicePoints();
		
		if ((pin.getSpotNumber() + steps) == 56){
			lastPinPlayed = pin;
			numberPlayerSucceed++;
			lastPinPlayed.goToHome();
			lastPinPlayed.disenable();				
			notifyMoveObservers();
			return;
		}
		
		pin.goForward(steps);		
		lastPinPlayed = pin;		
		notifyMoveObservers();
	}
	
	public void goForward(int spotNumber, int steps10or20) {
		Pin pin = getPinAtSpot(spotNumber);		
		if(pin==null)
			return;		
		int steps = steps10or20;		
				
		if ((pin.getSpotNumber() + steps) == 56){
			lastPinPlayed = pin;
			numberPlayerSucceed++;
			lastPinPlayed.goToHome();
			lastPinPlayed.disenable();
		}
		
		pin.goForward(steps);		
		lastPinPlayed = pin;		
		notifyMoveObservers();
	}
	
	public Pin getLastPinPlayed() {
		return lastPinPlayed;
	}
	
	public int getNumberPlayerSucceed() {
		return numberPlayerSucceed;
	}

	public Pin getPinAtSpot(int spotNumber) {
		for (Pin pin : pins) {
			if(pin.getSpotNumber() == spotNumber)
				return pin;
		}
		return null;
	}
	
	public List<Pin> getPinsAtSpot(int spotNumber){
		List<Pin> pinsAtSpot = new ArrayList<Pin>();
		for (Pin pin : pins) {
			if(pin.getSpotNumber() == spotNumber) {
				pinsAtSpot.add(pin);
			}
		}
		return pinsAtSpot;	
	}
	
	public List<Integer> getSpotNumbers() {
		List<Integer> spotNumbers = new ArrayList<Integer>();
		for (Pin pin : pins) {
			spotNumbers.add(pin.getSpotNumber());
		}
		return spotNumbers;
	}
	
	public List<Pin> getPins() {
		return this.pins;
	}
	
	public PlayerColor getColor() {
		return this.color;
	}

	public boolean allPinsOut() {
		int pinsOut = 0;
		
		for (Pin pin: pins) {
			if (pin.isAtHome()) return false;
			else pinsOut++;
		}
		
		if (pinsOut == 4) return true;
		
		return false;
	}
	
	
	public void rollDices(){
		dice.roll();
		
		if (canPlayAgain()) {
			continuedRollCount++;
		} else {
			continuedRollCount = 0;
		}
		notifyResultObservers();
	}
	public void rollDices(int numero){
		dice.roll(numero);
		
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

	public boolean hasDice() {
		return dice!=null;
	}

	public boolean canPlayAgain() {
		return (dice.getValue() == 6) && !exceedContinuedRoll();
	}
	
	public boolean isInitialSpotSelfBloqued() {
		int pinsAtInitialSpot = 0;
		
		for (Pin pin : pins) {
			if(pin.isAtInitialSpot())
				pinsAtInitialSpot++;
		}
		
		if(pinsAtInitialSpot > 0)
			return true;
		
		return false;
	}
	
	private boolean isSpotSelfBloqued(int targetSpot) {
		int pinsAtTargetSpot = 0;
		
		for (Pin pin : pins) {
			if(pin.getSpotNumber() == targetSpot)
				pinsAtTargetSpot++;
		}
		
		if(pinsAtTargetSpot > 1)
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
		int diceResult = getDicePoints();
		boolean anyPinAtHome = anyPinAtHome();
		boolean isInitialSpotBloqued = isInitialSpotSelfBloqued();
		return (diceResult == MUST_LEAVE_STEPS) && anyPinAtHome && !isInitialSpotBloqued;
	}
	
	public boolean canLeaveHomeSpot(int spotNumber) {
		
		Pin pin = getPinAtSpot(spotNumber);
		
		if(pin==null)
			return false;
		
		if(!pin.isEnabled())
			return false;

		if(pin.isAtHome()) {
			int steps = getDicePoints();
			boolean isInitialSpotBloqued = isInitialSpotSelfBloqued();
			
			if(steps == MUST_LEAVE_STEPS && !isInitialSpotBloqued)
				return true;
		}
		return false;
	}
	
	public boolean canLeaveHome() {
		if(!shouldLeaveHome())
			return false;
		
		for (Pin pin : pins) {
			if(pin.isAtHome() && canLeaveHomeSpot(pin.getSpotNumber())) {
				return true;
			}
		}
		return false;
	}
	
	public void leaveHome() {		
		if(canLeaveHome()) {
			Pin pinAtHome = getPinAtHome();
			pinAtHome.leaveHome();
			notifyMoveObservers();
		}
	}
	
	public boolean needsGoHome() {		
		if ((dice.getValue() == 6) && (continuedRollCount == 3 ) && (lastPinPlayed.getSpotNumber() < 52 ) ) {
			return true;
		}
		return false;
	}
	
	public void goHome(){	
		lastPinPlayed.goToHome();
		notifyMoveObservers();
	}
	
	public boolean hasBarreira(int targetSpot) {
	    List<Pin> pinsAtSpot = getPinsAtSpot(targetSpot); 		
		return pinsAtSpot.size() > 1;			
	}
	
	public boolean hasBarreira() {
		List<Integer> spots = this.getSpotNumbers();
		for (int j = 0; j < spots.size(); j++) {
			for (int i=0; i < spots.size(); i++) {
				if ((i != j) && (spots.get(i) == spots.get(j)))
						return true;
				i++;
			}
		}
		return false;
	}
	
	public List<Integer> spotsOfBarreira() {
		List<Integer> spots = this.getSpotNumbers();
		List<Integer> spotsOfBarreira = new ArrayList<Integer>();
		for (int j = 0; j < spots.size(); j++) {
			for (int i=0; i < spots.size(); i++) {
				if ((i != j) && (spots.get(i) == spots.get(j)))
						spotsOfBarreira.add(spots.get(j));
				i++;
			}
		}
		return spotsOfBarreira; 
	}
	
	public boolean needsOpenBarreira() {		
		if ((dice.getValue() == 6) && hasBarreira() ){
			return true;
		}
		return false;
	}
	
	
	public boolean isHomeSpot(int spotNumber) {
		return spotNumber < 0;
	}
	
	public boolean canMove(int spotNumber) {
		Pin pin = getPinAtSpot(spotNumber);
		
		if(pin==null)
			return false;
		
		if (!pin.isEnabled())
			return false;
		
		if(pin.isAtHome()) {
			return canLeaveHomeSpot(spotNumber);
		}
		else {
			int steps = getDicePoints();
			int targetSpot = pin.getSpotNumber() + steps; 
			
			if ((steps == 6) && allPinsOut() ) {
				targetSpot++;
			}
			
			if (targetSpot > LAST_SPOT_NUMBER)
				return false;
			
			if(isSpotSelfBloqued(targetSpot))
				return false;

			return true;
		}
	}

	public void goToHome(Pin pinEaten) {
		pinEaten.goToHome();
		notifyMoveObservers();
	}

	
	public boolean exceedContinuedRoll() {
		return continuedRollCount >= MAX_CONTINUED_ROLL;
	}
	
	public void finalizeGame(List<Player> classificacoes) {
		List<Color> classificacoesCores = new ArrayList<Color>();
		for (Player player : classificacoes) {
			switch(player.getColor()) {
				case RED:
					classificacoesCores.add(Color.RED);
					break;
				case GREEN:
					classificacoesCores.add(Color.GREEN);
					break;
				case YELLOW:
					classificacoesCores.add(Color.YELLOW);
					break;
				case BLUE:
					classificacoesCores.add(Color.BLUE);
					break;
			}		
		}
		
		notifyEndToMoveObservers(classificacoesCores);
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
		if(moveObservers == null)
			moveObservers = new ArrayList<IMoveObserver>();
			
		if(!moveObservers.contains(observer))
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
	
	public void notifyEndToMoveObservers(List<Color> classificacoesCores) {
		for (IMoveObserver observer : moveObservers) {
			observer.finalizeGame(classificacoesCores);
		}
	}

	@Override
	public void registerResultObserver(IObserver observer) {
		if(resultObservers == null)
			resultObservers = new ArrayList<IResultObserver>();
		
		if(!resultObservers.contains(observer))
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
	

	@Override
	public void registerEnableToObserver(IEnableToObserver observer) {
		if(enableToObservers == null)
			enableToObservers = new ArrayList<IEnableToObserver>();
		
		if(!enableToObservers.contains(observer))
			enableToObservers.add(observer);		
	}

	@Override
	public void removeEnableToObserver(IEnableToObserver observer) {
		enableToObservers.remove(observer);	
	}

	@Override
	public void notifyEnableToObservers() {
		for (IEnableToObserver observer : enableToObservers) {
			observer.EnableTo(this);
		}		
	}
}