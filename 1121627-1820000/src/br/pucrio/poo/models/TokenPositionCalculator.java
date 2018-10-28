package br.pucrio.poo.models;

public class TokenPositionCalculator {

	private int totalOfPins;
	private BoardSpotsCalculations spotsCalculation;
	private int tokenWidth;
	private int tokenHeight;

	public TokenPositionCalculator(int totalOfPins, BoardSpotsCalculations spotsCalculation, int tokenWidth,
			int tokenHeight) {
		this.totalOfPins = totalOfPins;
		this.spotsCalculation = spotsCalculation;
		this.tokenWidth = tokenWidth;
		this.tokenHeight = tokenHeight;
	}

	public Position getPositionOf(int spotNumber, int pinOrder) {
		Position spotMiddlePosition = spotsCalculation.getSpotPosition(spotNumber);
		double variationPercent = (double) pinOrder / totalOfPins - 0.5;
		Position variation = spotsCalculation.getSpotVariation(spotNumber, variationPercent);
		Position pinMiddlePosition = spotMiddlePosition.plus(variation);
		return pinMiddlePosition.plus(getVariationToPinBeInMiddleOfSpot());
	}

	private Position getVariationToPinBeInMiddleOfSpot() {
		double x = -tokenWidth / 2.0;
		double y = -tokenHeight / 2.0;
		return new Position(x, y);
	}

}
