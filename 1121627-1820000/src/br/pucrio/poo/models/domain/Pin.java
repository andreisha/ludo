package br.pucrio.poo.models.domain;

public class Pin {
	
	private static final int INITIAL_SPOT = 0;
	private int spotNumber;
	private int spotsQuantity;
	private boolean atHome;
	private int initialSpotNumber;

	public Pin(int spotsQuantity, int spotNumber) {
		this.spotsQuantity = spotsQuantity;
		this.spotNumber = spotNumber;
		this.initialSpotNumber = spotNumber;
		atHome = true;
	}

	public int getSpotNumber() {
		return this.spotNumber;
	}

	public void goForward(int steps) {
		if(isAtHome()) {
			this.spotNumber = INITIAL_SPOT;
			atHome = false;
		}
		
		else if (this.spotNumber + steps <= this.spotsQuantity) {
			this.spotNumber += steps;
		}
	}
	
	public void goToHome() {
		spotNumber = initialSpotNumber;
	}
	
	
	public boolean isAtHome() {
		return atHome;
	}
	
	public boolean isAtInitialSpot(){
		return spotNumber == initialSpotNumber;
	}
	
	public void leaveHome() {
		spotNumber = initialSpotNumber;
	}

	public boolean isFinalized() {
			return this.spotNumber == this.spotsQuantity;
		}
}
