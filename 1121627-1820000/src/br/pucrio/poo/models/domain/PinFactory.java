package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.List;

public class PinFactory {
	private int spotsQuantity;
	private static final int PIN_QUANTITY = 4;
	
	public PinFactory(int spotsQuantity) {
		this.spotsQuantity = spotsQuantity;
	}

	public List<Pin> getPin(PlayerColor color){
		List<Pin> pins = new ArrayList<Pin>();
		
		for (int spot = 0; spot < PIN_QUANTITY; spot++) {
			pins.add(new Pin(spotsQuantity,spot));
		}		
		return pins;
	}
	

}