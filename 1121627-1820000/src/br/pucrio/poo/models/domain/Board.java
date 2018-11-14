package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.CasaJogo;

public class Board {
	private int spotsQuantity;
	private List<CasaJogo> casas = new ArrayList<CasaJogo>();;
	
	public Board(int spotsQuantity) {
		this.spotsQuantity = spotsQuantity;
	}

	public int getSpotsQuantity() {
		return spotsQuantity;
	}

}
