package br.pucrio.poo.models;

import br.pucrio.poo.models.domain.PlayerColor;

public class TokenPositionCalculator {
	
	private BoardSpotsCalculations spotsCalculation;

	public TokenPositionCalculator(BoardSpotsCalculations spotsCalculation) {		
		this.spotsCalculation = spotsCalculation;
	}

	public Position getPositionOf(int relativeSpotNumber, PlayerColor color) {
		return spotsCalculation.getSpotPosition(relativeSpotNumber, color);
	}
	
	public int getSpotNumberFromRelativeSpotNumber(int relativeSpotNumber, PlayerColor color) {
		return spotsCalculation.getSpotNumber(relativeSpotNumber, color);
	}
}
