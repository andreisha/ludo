package br.pucrio.poo.models;

public class BoardSpotsCalculations {

	private int cellsInBoardSide;
	private int spotsBeforeCorner;
	private double boardWidth;
	private double boardHeight;

	public BoardSpotsCalculations(int spotsBeforeCorner, int cellsInBoardSide, double boardWidth, double boardHeight) {
		this.spotsBeforeCorner = spotsBeforeCorner;
		this.cellsInBoardSide = cellsInBoardSide;
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}

	public Position getSpotPosition(int spotNumber) {
		if (isCorner(spotNumber)) {
			int trailNumber = spotNumber / spotsBeforeCorner;
			return getCornerPosition(trailNumber);
		} else {
			return getInternalSpotPosition(spotNumber);
		}
	}

	public Position getSpotVariation(int spotNumber, double variationPercent) {
		if (areInRightTrail(spotNumber) || areInLeftTrail(spotNumber)) {
			double x = cellWidth() * 1.3 * variationPercent;
			return new Position(x, 0);
		} else {
			double y = cellHeight() * 1.3 * variationPercent;
			return new Position(0, y);
		}
	}

	private boolean isCorner(int spotNumber) {
		return spotNumber % spotsBeforeCorner == 0;
	}

	private Position getInternalSpotPosition(int spotNumber) {
		Position cornerBefore = getCornerPosition(spotNumber / spotsBeforeCorner);

		double x, y;
		if (areInRightTrail(spotNumber)) {
			x = cornerBefore.getX();
			y = cornerBefore.getY() + internalSpotHorizontalDistanceToCorner(spotNumber);
		} else if (areInLeftTrail(spotNumber)) {
			x = cornerBefore.getX();
			y = cornerBefore.getY() - internalSpotHorizontalDistanceToCorner(spotNumber);
		} else if (areInBottomTrail(spotNumber)) {
			x = cornerBefore.getX() - internalSpotVerticalDistanceToCorner(spotNumber);
			y = cornerBefore.getY();
		} else {
			x = cornerBefore.getX() + internalSpotVerticalDistanceToCorner(spotNumber);
			y = cornerBefore.getY();
		}
		return new Position(x, y);
	}

	private double internalSpotVerticalDistanceToCorner(int spotNumber) {
		return (spotNumber % spotsBeforeCorner) * cellWidth() + cellWidth() / 2;
	}

	private double internalSpotHorizontalDistanceToCorner(int spotNumber) {
		return (spotNumber % spotsBeforeCorner) * cellHeight() + cellHeight() / 2;
	}

	private boolean areInRightTrail(int spotNumber) {
		return spotNumber >= 0 && spotNumber <= spotsBeforeCorner;
	}

	private boolean areInBottomTrail(int spotNumber) {
		return spotNumber >= spotsBeforeCorner * 1 && spotNumber <= spotsBeforeCorner * 2;
	}

	private boolean areInLeftTrail(int spotNumber) {
		return spotNumber >= spotsBeforeCorner * 2 && spotNumber <= spotsBeforeCorner * 3;
	}

	private boolean areInTopTrail(int spotNumber) {
		return spotNumber >= spotsBeforeCorner * 3 && spotNumber <= spotsBeforeCorner * 4;
	}

	private Position getCornerPosition(int cornerNumber) {

		double x;
		double y;
		if (cornerNumber == 0 || cornerNumber == 1) {
			x = boardWidth - cellWidth();
		} else {
			x = cellWidth();
		}

		if (cornerNumber == 1 || cornerNumber == 2) {
			y = boardHeight - cellHeight();
		} else {
			y = cellHeight();
		}

		return new Position(x, y);
	}

	private double cellHeight() {
		return boardHeight / cellsInBoardSide;
	}

	private double cellWidth() {
		return boardWidth / cellsInBoardSide;
	}
}
