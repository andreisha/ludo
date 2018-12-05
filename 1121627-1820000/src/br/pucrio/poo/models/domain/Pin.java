package br.pucrio.poo.models.domain;

public class Pin {
	
	private static final int INITIAL_SPOT = 0;
	private int spotNumber;
	private int spotsQuantity;
	private int homeSpotNumber;

	public Pin(int spotsQuantity, int spotNumber) {
		this.spotsQuantity = spotsQuantity;
		this.spotNumber = spotNumber;
		this.homeSpotNumber = spotNumber;
	}

	public int getSpotNumber() {
		return this.spotNumber;
	}

	public void goForward(int steps) {
		if(isAtHome()) {
			this.spotNumber = INITIAL_SPOT;
		}
		
		else if (this.spotNumber + steps <= this.spotsQuantity) {
			this.spotNumber += steps;
		}
	}
	
	public void goToHome() {
		spotNumber = homeSpotNumber;
	}
	
	
	public boolean isAtHome() {
		return spotNumber == homeSpotNumber;
	}
	
	public boolean isAtInitialSpot(){
		return spotNumber == INITIAL_SPOT;
	}
	
	public void leaveHome() {
		spotNumber = INITIAL_SPOT;
	}

	public boolean isFinalized() {
			return this.spotNumber == this.spotsQuantity;
		}
}