package br.pucrio.poo.views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.CasaInicial;
import br.pucrio.poo.views.board.Reta;
import br.pucrio.poo.views.board.Token;

public class BoardPainter {
	private int boardWidth;
	private int boardHeight;
	private List<Casa> casasiniciais = new ArrayList<Casa>();
	private List<Casa> casas = new ArrayList<Casa>();
	private List<Reta> retas = new ArrayList<Reta>();
	
	
	public BoardPainter(int boardWidth, int boardHeight, int tokenRadius) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}
	
	public void paintBoard(Graphics2D graphics) {
		paintInicialArea(graphics);
		
		casas.add(new Casa(0,boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 0));
		casas.add(new Casa(boardWidth / 15, 2*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.RED, boardWidth/15, boardHeight/15, 1));
		casas.add(new Casa(2*boardWidth / 15, 3*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 2));
		casas.add(new Casa(3*boardWidth / 15, 4*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 3));
		casas.add(new Casa(4*boardWidth / 15, 5*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 4));
		casas.add(new Casa(5*boardWidth / 15, 6*boardWidth / 15, 6 * boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 5));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 5 * boardHeight / 15, 6* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 6));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 4 * boardHeight / 15, 5* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 7));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 3 * boardHeight / 15, 4* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 8));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 2 * boardHeight / 15, 3* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 9));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 1 * boardHeight / 15, 2* boardHeight / 15, Color.BLACK, boardWidth/15, boardHeight/15, 10));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth / 15, 0, boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 11));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth / 15, 0, boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 12));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 0, boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 13));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, boardHeight / 15, 2* boardHeight / 15, Color.GREEN, boardWidth/15, boardHeight/15, 14));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 2* boardHeight / 15, 3* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 15));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 3* boardHeight / 15, 4* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 16));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 4* boardHeight / 15, 5* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 17));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth / 15, 5* boardHeight / 15, 6* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 18));
		casas.add(new Casa(9*boardWidth / 15, 10*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 19));
		casas.add(new Casa(10*boardWidth / 15, 11*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 20));
		casas.add(new Casa(11*boardWidth / 15, 12*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 21));
		casas.add(new Casa(12*boardWidth / 15, 13*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 22));
		casas.add(new Casa(13*boardWidth / 15, 14*boardWidth / 15, 6* boardHeight / 15, 7* boardHeight / 15, Color.BLACK, boardWidth/15, boardHeight/15, 23));
		casas.add(new Casa(14*boardWidth / 15, boardWidth, 6* boardHeight / 15, 7* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 24));
		casas.add(new Casa(14*boardWidth / 15, boardWidth, 7* boardHeight / 15, 8* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 25));
		casas.add(new Casa(14*boardWidth / 15, boardWidth, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 26));
		casas.add(new Casa(13*boardWidth / 15, 14*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.YELLOW, boardWidth/15, boardHeight/15, 27));
		casas.add(new Casa(12*boardWidth / 15, 13*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 28));
		casas.add(new Casa(11*boardWidth / 15, 12*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 29));
		casas.add(new Casa(10*boardWidth / 15, 11*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 30));
		casas.add(new Casa(9*boardWidth / 15, 10*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 31));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 9* boardHeight / 15, 10* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 32));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 10* boardHeight / 15, 11* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 33));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 11* boardHeight / 15, 12* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 34));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 12* boardHeight / 15, 13* boardHeight / 15, Color.WHITE, boardWidth/15, boardHeight/15, 35));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 13* boardHeight / 15, 14* boardHeight / 15, Color.BLACK, boardWidth/15, boardHeight/15, 36));
		casas.add(new Casa(8*boardWidth / 15, 9*boardWidth/ 15, 14* boardHeight / 15, boardHeight, Color.WHITE, boardWidth/15, boardHeight/15, 37));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth/ 15, 14* boardHeight / 15, boardHeight, Color.WHITE, boardWidth/15, boardHeight/15, 38));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 14* boardHeight / 15, boardHeight, Color.WHITE, boardWidth/15, boardHeight/15, 39));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 13* boardHeight / 15, 14* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 40));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 12* boardHeight / 15, 13* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 41));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 11* boardHeight / 15, 12* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 42));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 10* boardHeight / 15, 11* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 43));
		casas.add(new Casa(6*boardWidth / 15, 7*boardWidth/ 15, 9* boardHeight / 15, 10* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 44));
		casas.add(new Casa(5*boardWidth / 15, 6*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 45));
		casas.add(new Casa(4*boardWidth / 15, 5*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 46));
		casas.add(new Casa(3*boardWidth / 15, 4*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 47));
		casas.add(new Casa(2*boardWidth / 15, 3*boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 48));
		casas.add(new Casa(boardWidth / 15, 2*boardWidth, 8* boardHeight / 15, 9* boardHeight /15, Color.BLACK, boardWidth/15, boardHeight/15, 49));
		casas.add(new Casa(0, boardWidth/ 15, 8* boardHeight / 15, 9* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 50));
		casas.add(new Casa(0, boardWidth/ 15, 7* boardHeight / 15, 8* boardHeight /15, Color.WHITE, boardWidth/15, boardHeight/15, 51));
	//finais vermelhas
		casas.add(new Casa(boardWidth / 15, 2*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, boardWidth/15, boardHeight/15,52));
		casas.add(new Casa(2*boardWidth / 15, 3*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, boardWidth/15, boardHeight/15, 53));
		casas.add(new Casa(3*boardWidth / 15, 4*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, boardWidth/15, boardHeight/15, 54));
		casas.add(new Casa(4*boardWidth / 15, 5*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, boardWidth/15, boardHeight/15, 55));
		casas.add(new Casa(5*boardWidth / 15, 6*boardWidth, 7* boardHeight / 15, 8* boardHeight /15, Color.RED, boardWidth/15, boardHeight/15, 56));
	//finais verdes
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, boardHeight / 15, 2* boardHeight /15, Color.GREEN, boardWidth/15, boardHeight/15, 57));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 2*boardHeight / 15, 3* boardHeight /15, Color.GREEN, boardWidth/15, boardHeight/15, 58));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 3*boardHeight / 15, 4* boardHeight /15, Color.GREEN, boardWidth/15, boardHeight/15, 59));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 4*boardHeight / 15, 5* boardHeight /15, Color.GREEN, boardWidth/15, boardHeight/15, 60));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 5*boardHeight / 15, 6* boardHeight /15, Color.GREEN, boardWidth/15, boardHeight/15, 61));
		//finais amarelas
		casas.add(new Casa(13*boardWidth / 15, 14*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, boardWidth/15, boardHeight/15, 62));
		casas.add(new Casa(12*boardWidth / 15, 13*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, boardWidth/15, boardHeight/15, 63));
		casas.add(new Casa(11*boardWidth / 15, 12*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, boardWidth/15, boardHeight/15, 64));
		casas.add(new Casa(10*boardWidth / 15, 11*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, boardWidth/15, boardHeight/15, 65));
		casas.add(new Casa(9*boardWidth / 15, 10*boardWidth, 7*boardHeight / 15, 8* boardHeight /15, Color.YELLOW, boardWidth/15, boardHeight/15, 66));		
		//finais azuis
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 13*boardHeight / 15, 14* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 67));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 12*boardHeight / 15, 13* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 68));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 11*boardHeight / 15, 12* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 69));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 10*boardHeight / 15, 11* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 70));
		casas.add(new Casa(7*boardWidth / 15, 8*boardWidth, 9*boardHeight / 15, 10* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 71));
	
		//casas iniciais
		casas.add(new CasaInicial(boardWidth / 15, 2*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.RED, boardWidth/15, boardHeight/15, 72));
		casas.add(new CasaInicial(4*boardWidth / 15, 5*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.RED, boardWidth/15, boardHeight/15, 73));
		casas.add(new CasaInicial(boardWidth / 15, 2*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.RED, boardWidth/15, boardHeight/15, 74));
		casas.add(new CasaInicial(4*boardWidth / 15, 5*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.RED, boardWidth/15, boardHeight/15, 75));

		casas.add(new CasaInicial(10*boardWidth / 15, 11*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.GREEN, boardWidth/15, boardHeight/15, 76));
		casas.add(new CasaInicial(13*boardWidth / 15, 14*boardWidth / 15, boardHeight / 15, 2* boardHeight /15, Color.GREEN, boardWidth/15, boardHeight/15, 77));
		casas.add(new CasaInicial(10*boardWidth / 15, 11*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.GREEN, boardWidth/15, boardHeight/15, 78));
		casas.add(new CasaInicial(13*boardWidth / 15, 14*boardWidth / 15, 4*boardHeight / 15, 5* boardHeight /15, Color.GREEN, boardWidth/15, boardHeight/15, 79));

		casas.add(new CasaInicial(10*boardWidth / 15, 11*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.YELLOW, boardWidth/15, boardHeight/15, 80));
		casas.add(new CasaInicial(13*boardWidth / 15, 14*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.YELLOW, boardWidth/15, boardHeight/15, 81));
		casas.add(new CasaInicial(10*boardWidth / 15, 11*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.YELLOW, boardWidth/15, boardHeight/15, 82));
		casas.add(new CasaInicial(13*boardWidth / 15, 14*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.YELLOW, boardWidth/15, boardHeight/15, 83));

		casas.add(new CasaInicial(boardWidth / 15, 2*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 84));
		casas.add(new CasaInicial(4*boardWidth / 15, 5*boardWidth / 15, 10*boardHeight / 15, 11* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 85));
		casas.add(new CasaInicial(boardWidth / 15, 2*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 86));
		casas.add(new CasaInicial(4*boardWidth / 15, 5*boardWidth / 15, 13*boardHeight / 15, 14* boardHeight /15, Color.BLUE, boardWidth/15, boardHeight/15, 87));
		
		/*casas.add(new CasaInicial(6*boardWidth / 15, 7*boardWidth / 15, 7*boardHeight / 15, 8* boardHeight /15, null, boardWidth/15, boardHeight/15, 88));
		casas.add(new CasaInicial(7*boardWidth / 15, 8*boardWidth / 15, 6*boardHeight / 15, 7* boardHeight /15, null, boardWidth/15, boardHeight/15, 89));
		casas.add(new CasaInicial(8*boardWidth / 15, 7*boardWidth / 15, 7*boardHeight / 15, 8* boardHeight /15, null, boardWidth/15, boardHeight/15, 90));
		casas.add(new CasaInicial(7*boardWidth / 15, 8*boardWidth / 15, 8*boardHeight / 15, 9* boardHeight /15, null, boardWidth/15, boardHeight/15, 91));
*/
		for (Casa casa : casas) {
			casa.paintCasa(graphics);
		}
		
		// desenho dos triangulos centrais 
		paintCentralTriangles(graphics);
	}
	 
	public List<Casa> getCasas(){
		return casas;	
	}

	private void paintInitialSquares(Graphics2D graphics) {
		Casa casa = null;
		for (int x = 0; x < 14; x++) {
			for (int y = 0; y < 15; y++) {
				if((x == 1 || x == 4) && (y == 1 || y == 4))
					casa = new CasaInicial(x * boardWidth / 15,(x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15,Color.red,  boardWidth / 15, boardHeight / 15, -12);
				else if((x == 1 || x == 4) && (y == 10 || y == 13))
					casa = new CasaInicial(x * boardWidth / 15,(x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15,Color.blue,  boardWidth / 15, boardHeight / 15, -12);
				else if((x == 10 || x == 13) && (y == 1 || y == 4))
					casa = new CasaInicial(x * boardWidth / 15,(x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15,Color.green,  boardWidth / 15, boardHeight / 15, -12);
				else if((x == 10 || x == 13) && (y == 10 || y == 13))
					casa = new CasaInicial(x * boardWidth / 15,(x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15,Color.yellow,  boardWidth / 15, boardHeight / 15, -12);	
				if(casa!= null) {
					this.casas.add(casa);
					casa.paintCasa(graphics);
				}
			}
		}
	}

	private void paintCentralTriangles(Graphics2D graphics) {
		int xred[] = { 6 * boardWidth / 15, (15 * boardWidth + 15) / 30, 6 * boardWidth / 15 };
		int yred[] = { 6 * boardHeight / 15, (15 * boardHeight + 15) / 30, 9 * boardHeight / 15 };
		int xgreen[] = { 6 * boardWidth / 15, (15 * boardWidth + 15) / 30, 9 * boardWidth / 15 };
		int ygreen[] = { 6 * boardHeight / 15, (15 * boardHeight + 15) / 30, 6 * boardHeight / 15 };
		int xyellow[] = { 9 * boardWidth / 15, (15 * boardWidth + 15) / 30, 9 * boardWidth / 15 };
		int yyellow[] = { 6 * boardHeight / 15, (15 * boardHeight + 15) / 30, 9 * boardHeight / 15 };
		int xblue[] = { 6 * boardWidth / 15, (15 * boardWidth + 15) / 30, 9 * boardWidth / 15 };
		int yblue[] = { 9 * boardHeight / 15, (15 * boardHeight + 15) / 30, 9 * boardHeight / 15 };

		int x_retabr_red[] = {(5 * boardWidth + 15) / 60, (7 * boardWidth + 15) / 60, (5 * boardWidth + 15) / 60};
		int y_retabr_red[] = {(25 * boardHeight + 15) / 60, (13 * boardHeight + 15) / 30, (27 * boardHeight + 45) / 60};
		
		int x_retabr_green[] = {(33 * boardWidth + 15) / 60, (34 * boardWidth + 15) / 60, (35 * boardWidth + 15) / 60};
		int y_retabr_green[] = {(5 * boardHeight + 15) / 60, (7 * boardHeight + 15) / 60, (5 * boardHeight + 15) / 60};
		
		int x_retabr_yellow[] = {(55 * boardWidth + 15) / 60, (53 * boardWidth + 15) / 60, (55 * boardWidth + 15) / 60};
		int y_retabr_yellow[] = {(33 * boardHeight + 15) / 60, (34 * boardHeight + 15) / 60, (35 * boardHeight + 15) / 60};
		
		int x_retabr_blue[] = {(25 * boardWidth + 15) / 60, (26 * boardWidth + 15) / 60, (27 * boardWidth + 15) / 60};
		int y_retabr_blue[] = {(55 * boardHeight + 15) / 60, (53 * boardHeight + 15) / 60, (55 * boardHeight + 15) / 60};
					
		
		this.retas.add(new Reta(xred, yred, Color.RED));
		this.retas.add(new Reta(xgreen, ygreen, Color.GREEN));
		this.retas.add(new Reta(xyellow, yyellow, Color.YELLOW));
		this.retas.add(new Reta(xblue, yblue, Color.BLUE));
		this.retas.add(new Reta(x_retabr_red, y_retabr_red, Color.WHITE));
		this.retas.add(new Reta(x_retabr_green, y_retabr_green, Color.WHITE));
		this.retas.add(new Reta(x_retabr_yellow, y_retabr_yellow, Color.WHITE));
		this.retas.add(new Reta(x_retabr_blue, y_retabr_blue, Color.WHITE));

		for (Reta reta : this.retas) {
			reta.paintReta(graphics);
		}
	}

	private void paintVerticalSquares(Graphics2D graphics) {
		
		Casa casa = null;
		for (int x = 6; x < 9; x++) {
			for (int y = 0; y < 15; y++) {
				if (((x == 6) & (y == 1)) | ((x == 8) & (y == 13)))// pretas
					casa = new Casa(x * boardWidth / 15, (x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15, Color.BLACK, boardWidth / 15, boardHeight / 15, -9);

				else if (((x == 7) & (y > 0) & (y < 6)) | (x == 8 & y == 1))// verdes
					casa = new Casa(x * boardWidth / 15, (x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15, Color.GREEN, boardWidth / 15, boardHeight / 15, -10);

				else if (((x == 7) & (y > 8) & (y < 14)) | (x == 6 & y == 13))// azuis
					casa = new Casa(x * boardWidth / 15,(x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15, Color.BLUE, boardWidth / 15, boardHeight / 15, -11);

				else if((x == 6 && (y == 0 || (y > 1 && y < 6) || (y > 8 && y < 13) || y == 14)) ||
						(x == 7 && (y == 0 || y == 14)) ||
						(x == 8 && (y == 0 || (y > 1 && y < 6) || (y > 8 && y < 13) || y == 14)))
					casa = new Casa(x * boardWidth / 15,(x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15,Color.WHITE,  boardWidth / 15, boardHeight / 15, -12);

				this.casas.add(casa);
				casa.paintCasa(graphics);
			}
		}
	}

	private void paintHorizontalSquares(Graphics2D graphics) {
		Casa casa = null;
		for (int x = 0; x < 15; x++) {
			for (int y = 6; y < 9; y++) {
				if (((x == 13) & (y == 6)) | ((x == 1) & (y == 8))) // pretas
					casa = new Casa(x * boardWidth / 15, (x+1)* boardWidth / 15, y * boardHeight / 15, (y+1) * boardHeight / 15, Color.BLACK, boardWidth / 15, boardHeight / 15, -5);

				else if (((y == 7) & (x > 0) & (x < 6)) | (x == 1 & y == 6))// vermelhas
					casa = new Casa(x * boardWidth / 15, (x+1)*boardWidth / 15, y * boardHeight / 15, (y+1) * boardHeight / 15, Color.RED, boardWidth / 15, boardHeight / 15, -6);

				else if (((y == 7) & (x > 8) & (x < 14)) | (x == 13 & y == 8))// amarelas
					casa = new Casa(x * boardWidth / 15,(x+1)*boardWidth / 15,  y * boardHeight / 15, (y+1) * boardHeight / 15,Color.YELLOW, boardWidth / 15, boardHeight / 15, -7);

				else if((y == 6 && (x == 0 || (x > 1 && x < 6) || (x > 8 && x < 13) || x == 14)) ||
						(y == 7 && (x == 0 || x == 14)) ||
						(y == 8 && (x == 0 || (x > 1 && x < 6) || (x > 8 && x < 13) || x == 14)))
					casa = new Casa(x * boardWidth / 15, (x+1)*boardWidth / 15, y * boardHeight / 15, (y+1) * boardHeight / 15, Color.WHITE, boardWidth / 15, boardHeight / 15, -8);

				this.casas.add(casa);
				casa.paintCasa(graphics);
			}
		}
	}

	private void paintInicialArea(Graphics2D graphics) {
		this.casasiniciais.add(new Casa(0, 6* boardWidth /15, 0, 6*boardHeight /15, Color.RED, 6 * boardWidth / 15, 6 * boardHeight / 15, -1));
		this.casasiniciais.add(new Casa(9 * boardWidth / 15, boardWidth, 0, 6*boardHeight /15, Color.GREEN, 6 * boardWidth / 15, 6 * boardHeight / 15, -2));
		this.casasiniciais.add(new Casa(9 * boardWidth / 15, boardWidth, 9 * boardHeight / 15, boardHeight, Color.YELLOW, 6 * boardWidth / 15,6 * boardHeight / 15, -3));
		this.casasiniciais.add(new Casa(0, 6* boardWidth /15, 9 * boardHeight / 15,boardHeight, Color.BLUE, 6 * boardWidth / 15, 6 * boardHeight / 15, -4));

		for (Casa casa : this.casasiniciais) {
			casa.paintCasa(graphics);
		}
	}

}