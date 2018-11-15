package br.pucrio.poo.views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.Reta;
import br.pucrio.poo.views.board.Token;

public class BoardPainter {
	private int boardWidth;
	private int boardHeight;
	private int tokenRadius;
	private List<Casa> casasiniciais = new ArrayList<Casa>();;
	private List<Casa> casas = new ArrayList<Casa>();;
	private List<Reta> retas = new ArrayList<Reta>();;
	private List<Token> tokensbrancos = new ArrayList<Token>();;
	private List<Token> tokens = new ArrayList<Token>();;
	
	
	public BoardPainter(int boardWidth, int boardHeight, int tokenRadius) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.tokenRadius = tokenRadius;
	}

	public void paintBoard(Graphics2D graphics) {

		/* desenho das casas iniciais */
		this.casasiniciais.add(new Casa(0, 6* boardWidth /15, 0, 6*boardHeight /15, Color.RED, false, 6 * boardWidth / 15, 6 * boardHeight / 15, false, -1, null, null));
		this.casasiniciais.add(new Casa(9 * boardWidth / 15, boardWidth, 0, 6*boardHeight /15, Color.GREEN, false, 6 * boardWidth / 15, 6 * boardHeight / 15, false, -2, null, null));
		this.casasiniciais.add(new Casa(9 * boardWidth / 15, boardWidth, 9 * boardHeight / 15, boardHeight, Color.YELLOW, false, 6 * boardWidth / 15,6 * boardHeight / 15, false, -3, null, null));
		this.casasiniciais.add(new Casa(0, 6* boardWidth /15, 9 * boardHeight / 15,boardHeight, Color.BLUE, false, 6 * boardWidth / 15, 6 * boardHeight / 15, false, -4, null, null));

		for (Casa casa : this.casasiniciais) {
			casa.paintCasa(graphics);
		}

		Casa br;

		

		/* desenho das casas horizontais */
		for (int x = 0; x < 15; x++) {
			for (int y = 6; y < 9; y++) {

				if (((x == 13) & (y == 6)) | ((x == 1) & (y == 8))) // pretas
					br = new Casa(x * boardWidth / 15, (x+1)* boardWidth / 15, y * boardHeight / 15, (y+1) * boardHeight / 15, Color.BLACK, false, boardWidth / 15, boardHeight / 15, false, -5, null, null);

				else if (((y == 7) & (x > 0) & (x < 6)) | (x == 1 & y == 6))// vermelhas
					br = new Casa(x * boardWidth / 15, (x+1)*boardWidth / 15, y * boardHeight / 15, (y+1) * boardHeight / 15, Color.RED, false, boardWidth / 15, boardHeight / 15,false, -6, null, null);

				else if (((y == 7) & (x > 8) & (x < 14)) | (x == 13 & y == 8))// amarelas
					br = new Casa(x * boardWidth / 15,(x+1)*boardWidth / 15,  y * boardHeight / 15, (y+1) * boardHeight / 15,Color.YELLOW, false, boardWidth / 15, boardHeight / 15, false, -7, null, null);

				else
					br = new Casa(x * boardWidth / 15, (x+1)*boardWidth / 15, y * boardHeight / 15, (y+1) * boardHeight / 15, Color.WHITE, false, boardWidth / 15, boardHeight / 15, false, -8, null, null);

				this.casas.add(br);
				br.paintCasa(graphics);
			}
		}

		/* desenho das casas brancas verticais */


		
		for (int x = 6; x < 9; x++) {
			for (int y = 0; y < 15; y++) {
				if (((x == 6) & (y == 1)) | ((x == 8) & (y == 13)))// pretas
					br = new Casa(x * boardWidth / 15, (x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15, Color.BLACK, false, boardWidth / 15, boardHeight / 15,false, -9, null, null);

				else if (((x == 7) & (y > 0) & (y < 6)) | (x == 8 & y == 1))// verdes
					br = new Casa(x * boardWidth / 15, (x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15, Color.GREEN, false, boardWidth / 15, boardHeight / 15,false, -10, null, null);

				else if (((x == 7) & (y > 8) & (y < 14)) | (x == 6 & y == 13))// azuis
					br = new Casa(x * boardWidth / 15,(x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15, Color.BLUE, false, boardWidth / 15, boardHeight / 15,false, -11, null, null);

				else
					br = new Casa(x * boardWidth / 15,(x+1) * boardWidth / 15, y * boardHeight / 15,(y+1) * boardHeight / 15,Color.WHITE, false,  boardWidth / 15, boardHeight / 15,false, -12, null, null);

				this.casas.add(br);
				br.paintCasa(graphics);
			}
		}

		/* desenho dos triangulos centrais */

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
		
		/* desenho dos circulos dos retangulos */
				
		this.tokensbrancos.add(new Token(boardWidth/15,boardHeight/15, Color.WHITE, 30, 72));
		this.tokensbrancos.add(new Token(4*boardWidth/15,boardHeight/15, Color.WHITE, 30, 73));
		this.tokensbrancos.add(new Token(boardWidth/15,4*boardHeight/15, Color.WHITE, 30, 74));
		this.tokensbrancos.add(new Token(4*boardWidth/15,4*boardHeight/15, Color.WHITE, 30, 75));
		
		this.tokensbrancos.add(new Token(10*boardWidth/15,boardHeight/15, Color.WHITE, 30, 76));
		this.tokensbrancos.add(new Token(13*boardWidth/15,boardHeight/15, Color.WHITE, 30, 77));
		this.tokensbrancos.add(new Token(10*boardWidth/15,4*boardHeight/15, Color.WHITE, 30, 78));
		this.tokensbrancos.add(new Token(13*boardWidth/15,4*boardHeight/15, Color.WHITE, 30, 79));

		this.tokensbrancos.add(new Token(boardWidth/15,10*boardHeight/15, Color.WHITE, 30, 80));
		this.tokensbrancos.add(new Token(4*boardWidth/15,10*boardHeight/15, Color.WHITE, 30, 81));
		this.tokensbrancos.add(new Token(boardWidth/15,13*boardHeight/15, Color.WHITE,30, 82));
		this.tokensbrancos.add(new Token(4*boardWidth/15,13*boardHeight/15, Color.WHITE, 30, 83));

		this.tokensbrancos.add(new Token(10*boardWidth/15,10*boardHeight/15, Color.WHITE, 30, 84));
		this.tokensbrancos.add(new Token(13*boardWidth/15,10*boardHeight/15, Color.WHITE, 30, 85));
		this.tokensbrancos.add(new Token(10*boardWidth/15,13*boardHeight/15, Color.WHITE, 30, 86));
		this.tokensbrancos.add(new Token(13*boardWidth/15,13*boardHeight/15, Color.WHITE, 30, 87));

		for (Token token : this.tokensbrancos) {
			token.paintToken(graphics, token.getX(), token.getY());
			}

		/* desenho dos tokens para jogar */
		
	
	}

}
