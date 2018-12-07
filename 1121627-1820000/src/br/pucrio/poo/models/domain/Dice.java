package br.pucrio.poo.models.domain;

import java.util.Random;

import com.google.gson.annotations.Expose;

public class Dice {
	@Expose private int value;

	public void roll() {
		value = new Random().nextInt(6) + 1;
	}

	public void roll(int numero) {
		value = numero;
	}

	public String toString() {
		return String.valueOf(this.value);
	}

	public int getValue() {
		return value;
	}
}