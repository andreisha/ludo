package br.pucrio.poo.controllers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.CasaJogo;

public class NewGameController {

	private List<CasaJogo> casas = new ArrayList<CasaJogo>();;

	public NewGameController () {

	};
	
	
	public List<CasaJogo> getCasas(){
		return casas;
	}

	public void startNewGame(final int boardWidth, final int boardHeight) {
	//71 casas para jogar  => 87 casas onde pode estar o token (casas iniciais incluidas)
		this.casas.add(new CasaJogo(0,boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 0, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(boardWidth / 15, 2*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.RED, true, false, 1, Color.RED,Color.WHITE));
		this.casas.add(new CasaJogo(2*boardWidth / 15, 3*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 2, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(3*boardWidth / 15, 4*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 3, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(4*boardWidth / 15, 5*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 4, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(5*boardWidth / 15, 6*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 5, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth / 15, 5 * boardHeight / 15, 6* boardHeight / 15, Color.WHITE, false, false, 6, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth / 15, 4 * boardHeight / 15, 5* boardHeight / 15, Color.WHITE, false, false, 7, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth / 15, 3 * boardHeight / 15, 4* boardHeight / 15, Color.WHITE, false, false, 8, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth / 15, 2 * boardHeight / 15, 3* boardHeight / 15, Color.WHITE, false, false, 9, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth / 15, 1 * boardHeight / 15, 2* boardHeight / 15, Color.BLACK, false, false, 10, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth / 15, 0, boardHeight / 15, Color.WHITE, false, false, 11, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth / 15, 0, boardHeight / 15, Color.WHITE, false, false, 12, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth / 15, 0, boardHeight / 15, Color.WHITE, false, false, 13, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth / 15, boardHeight / 15, 2* boardHeight / 15, Color.GREEN, true, false, 14, Color.GREEN,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth / 15, 2* boardHeight / 15, 3* boardHeight / 15, Color.WHITE, false, false, 15, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth / 15, 3* boardHeight / 15, 4* boardHeight / 15, Color.WHITE, false, false, 16, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth / 15, 4* boardHeight / 15, 5* boardHeight / 15, Color.WHITE, false, false, 17, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth / 15, 5* boardHeight / 15, 6* boardHeight / 15, Color.WHITE, false, false, 18, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(9*boardWidth / 15, 10*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 19, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(10*boardWidth / 15, 11*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 20, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(11*boardWidth / 15, 12*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 21, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(12*boardWidth / 15, 13*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 22, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(13*boardWidth / 15, 14*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.BLACK, false, false, 23, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(14*boardWidth / 15, boardWidth, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, false, false, 24, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(14*boardWidth / 15, boardWidth, 7* boardHeight / 15, 8* boardHeight / 15, Color.WHITE, false, false, 25, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(14*boardWidth / 15, boardWidth, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, false, 26, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(13*boardWidth / 15, 14*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.YELLOW, true, false, 27, Color.YELLOW,Color.WHITE));
		this.casas.add(new CasaJogo(12*boardWidth / 15, 13*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, false, 28, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(11*boardWidth / 15, 12*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, false, 29, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(10*boardWidth / 15, 11*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, false, 30, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(9*boardWidth / 15, 10*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, false, false, 31, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth/ 15, 9* boardHeight / 15, 10* boardHeight / 15, Color.WHITE, false, false, 32, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth/ 15, 10* boardHeight / 15, 11* boardHeight / 15, Color.WHITE, false, false, 33, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth/ 15, 11* boardHeight / 15, 12* boardHeight / 15, Color.WHITE, false, false, 34, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth/ 15, 12* boardHeight / 15, 13* boardHeight / 15, Color.WHITE, false, false, 35, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth/ 15, 13* boardHeight / 15, 14* boardHeight / 15, Color.BLACK, false, false, 36, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(8*boardWidth / 15, 9*boardWidth/ 15, 14* boardHeight / 15, boardHeight, Color.WHITE, false, false, 37, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth/ 15, 14* boardHeight / 15, boardHeight, Color.WHITE, false, false, 38, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth/ 15, 14* boardHeight / 15, boardHeight, Color.WHITE, false, false, 39, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth/ 15, 13* boardHeight / 15, 14* boardHeight /15, Color.BLUE, true, false, 40, Color.BLUE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth/ 15, 12* boardHeight / 15, 13* boardHeight /15, Color.WHITE, false, false, 41, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth/ 15, 11* boardHeight / 15, 12* boardHeight /15, Color.WHITE, false, false, 42, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth/ 15, 10* boardHeight / 15, 11* boardHeight /15, Color.WHITE, false, false, 43, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(6*boardWidth / 15, 7*boardWidth/ 15, 9* boardHeight / 15, 10* boardHeight /15, Color.WHITE, false, false, 44, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(5*boardWidth / 15, 6*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, false, 45, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(4*boardWidth / 15, 5*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, false, 46, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(3*boardWidth / 15, 4*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, false, 47, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(2*boardWidth / 15, 3*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, false, 48, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(boardWidth / 15, 2*boardWidth, 8* boardHeight / 15, 9* boardHeight /15, Color.BLACK, false, false, 49, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(0, boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, false, false, 50, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(0, boardWidth/ 15, 7* boardHeight / 15, 8* boardHeight /15, Color.WHITE, false, false, 51, Color.WHITE,Color.WHITE));
	//finais vermelhas
		this.casas.add(new CasaJogo(boardWidth / 15, 2*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, true, 52, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(2*boardWidth / 15, 3*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, true, 53, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(3*boardWidth / 15, 4*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, true, 54, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(4*boardWidth / 15, 5*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, true, 55, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(5*boardWidth / 15, 6*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, false, true, 56, Color.WHITE,Color.WHITE));
	//finais verdes
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, boardHeight / 15, 2* boardHeight /15, Color.GREEN, false, true, 57, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, 2*boardHeight / 15, 3* boardHeight /15, Color.GREEN, false, true, 58, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, 3*boardHeight / 15, 4* boardHeight /15, Color.GREEN, false, true, 59, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, 4*boardHeight / 15, 5* boardHeight /15, Color.GREEN, false, true, 60, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, 5*boardHeight / 15, 6* boardHeight /15, Color.GREEN, false, true, 61, Color.WHITE,Color.WHITE));
		//finais amarelas
		this.casas.add(new CasaJogo(13*boardWidth / 15, 14*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, true, 62, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(12*boardWidth / 15, 13*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, true, 63, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(11*boardWidth / 15, 12*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, true, 64, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(10*boardWidth / 15, 11*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, true, 65, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(9*boardWidth / 15, 10*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, false, true, 66, Color.WHITE,Color.WHITE));		
		//finais verdes
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, 13*boardHeight / 15, 14* boardHeight /15, Color.BLUE, false, true, 67, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, 12*boardHeight / 15, 13* boardHeight /15, Color.BLUE, false, true, 68, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, 11*boardHeight / 15, 12* boardHeight /15, Color.BLUE, false, true, 69, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, 10*boardHeight / 15, 11* boardHeight /15, Color.BLUE, false, true, 70, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(7*boardWidth / 15, 8*boardWidth, 9*boardHeight / 15, 10* boardHeight /15, Color.BLUE, false, true, 71, Color.WHITE,Color.WHITE));
	
		//casas iniciais
		this.casas.add(new CasaJogo(boardWidth / 15, 2*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.RED, false, false, 72, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(4*boardWidth / 15, 5*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.RED, false, false, 73, Color.RED,Color.WHITE));
		this.casas.add(new CasaJogo(boardWidth / 15, 2*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.RED, false, false, 74, Color.RED,Color.WHITE));
		this.casas.add(new CasaJogo(4*boardWidth / 15, 5*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.RED, false, false, 75, Color.RED,Color.WHITE));

		this.casas.add(new CasaJogo(10*boardWidth / 15, 11*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.GREEN, false, false, 76, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(13*boardWidth / 15, 14*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.GREEN, false, false, 77, Color.GREEN,Color.WHITE));
		this.casas.add(new CasaJogo(10*boardWidth / 15, 11*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.GREEN, false, false, 78, Color.GREEN,Color.WHITE));
		this.casas.add(new CasaJogo(13*boardWidth / 15, 14*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.GREEN, false, false, 79, Color.GREEN,Color.WHITE));

		this.casas.add(new CasaJogo(10*boardWidth / 15, 11*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.YELLOW, false, false, 80, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(13*boardWidth / 15, 14*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.YELLOW, false, false, 81, Color.YELLOW,Color.WHITE));
		this.casas.add(new CasaJogo(10*boardWidth / 15, 11*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.YELLOW, false, false, 82, Color.YELLOW,Color.WHITE));
		this.casas.add(new CasaJogo(13*boardWidth / 15, 14*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.YELLOW, false, false, 83, Color.YELLOW,Color.WHITE));

		this.casas.add(new CasaJogo(boardWidth / 15, 2*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.BLUE, false, false, 84, Color.WHITE,Color.WHITE));
		this.casas.add(new CasaJogo(4*boardWidth / 15, 5*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.BLUE, false, false, 85, Color.BLUE,Color.WHITE));
		this.casas.add(new CasaJogo(boardWidth / 15, 2*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.BLUE, false, false, 86, Color.BLUE,Color.WHITE));
		this.casas.add(new CasaJogo(4*boardWidth / 15, 5*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.BLUE, false, false, 87, Color.BLUE,Color.WHITE));

		
	}

}
