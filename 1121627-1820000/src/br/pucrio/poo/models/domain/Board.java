package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.views.board.Casa;

public class Board {
	private int spotsQuantity;
	
	public Board(int spotsQuantity) {
		this.spotsQuantity = spotsQuantity;
	}

	public int getSpotsQuantity() {
		return spotsQuantity;
	}

}
