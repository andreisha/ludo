package br.pucrio.poo.models.domain;

public class Pin {

	private int spotNumber;
	private int spotsQuantity;
	private boolean atHome;

	public Pin(int spotsQuantity, int spotNumber) {
		this.spotsQuantity = spotsQuantity;
		this.spotNumber = spotNumber;
		atHome = true;
	}

	public int getSpotNumber() {
		return this.spotNumber;
	}

	public void goForward(int steps) {
		if(isAtHome()) {
			this.spotNumber = steps;
			atHome = false;
		}
		
		else if (this.spotNumber + steps <= this.spotsQuantity) {
			this.spotNumber += steps;
		}
	}
	
	public boolean isAtHome() {
		return atHome;
	}

	public boolean isFinalized() {
			return this.spotNumber == this.spotsQuantity;
		}
}
