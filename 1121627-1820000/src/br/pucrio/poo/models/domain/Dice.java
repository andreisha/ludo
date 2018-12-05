package br.pucrio.poo.models.domain;

import java.util.Random;

public enum Dice {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

	private int value;

	public static Dice roll() {
		return from(new Random().nextInt(6) + 1);
	}

	public static Dice roll(int numero) {
		return from(numero);
	}
	
	public static Dice from(int number) {
		switch (number) {
		case 1:
			return ONE;
		case 2:
			return TWO;
		case 3:
			return THREE;
		case 4:
			return FOUR;
		case 5:
			return FIVE;
		case 6:
			return SIX;
		default:
			return SIX;
		}
	}

	Dice(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}

	public int getValue() {
		return value;
	}
}