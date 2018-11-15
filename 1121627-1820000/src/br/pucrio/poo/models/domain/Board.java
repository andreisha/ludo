package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.views.board.Casa;

public class Board {
	private int spotsQuantity;
	private List<Casa> casas = new ArrayList<Casa>();;
	
	public Board(int spotsQuantity) {
		this.spotsQuantity = spotsQuantity;
	}

	public int getSpotsQuantity() {
		return spotsQuantity;
	}

}
