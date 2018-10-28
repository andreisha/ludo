package br.pucrio.poo.models;

public class Position {

	private double y;
	private double x;

	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

	public int getRoundedX() {
		return (int) Math.round(x);
	}

	public int getRoundedY() {
		return (int) Math.round(y);
	}

	public Position plus(Position otherPosition) {
		double newX = otherPosition.getX() + this.x;
		double newY = otherPosition.getY() + this.y;
		return new Position(newX, newY);
	}

}
