package br.pucrio.poo.models.domain;

import com.google.gson.annotations.Expose;

public class Pin {
	
	private static final int INITIAL_SPOT = 0;
	@Expose private int spotNumber;
	@Expose private int spotsQuantity;
	@Expose private int homeSpotNumber;
	@Expose private boolean enabled = true;
	@Expose private PlayerColor playerColor;
	
	public Pin(PlayerColor playerColor, int spotsQuantity, int spotNumber) {
		this.spotsQuantity = spotsQuantity;
		this.spotNumber = spotNumber;
		this.homeSpotNumber = spotNumber;
		this.playerColor = playerColor;
	}

	public int getSpotNumber() {
		return this.spotNumber;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void disenable() {
		enabled = false;
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
	
	public PlayerColor getPlayerColor() {
		return playerColor;
	}

	public boolean isAtHome() {
		return ((spotNumber == homeSpotNumber) && isEnabled());
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