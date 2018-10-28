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

	public BoardPainter(int boardWidth, int boardHeight, int tokenRadius) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.tokenRadius = tokenRadius;
	}

	public void paintBoard(Graphics2D graphics) {

		/* desenho das casas iniciais */
		this.casasiniciais.add(new Casa(0, 0, 6 * boardWidth / 15, 6 * boardHeight / 15, Color.RED));
		this.casasiniciais
				.add(new Casa(9 * boardWidth / 15, 0, 6 * boardWidth / 15, 6 * boardHeight / 15, Color.GREEN));
		this.casasiniciais
				.add(new Casa(0, 9 * boardHeight / 15, 6 * boardWidth / 15, 6 * boardHeight / 15, Color.BLUE));
		this.casasiniciais.add(new Casa(9 * boardWidth / 15, 9 * boardHeight / 15, 6 * boardWidth / 15,
				6 * boardHeight / 15, Color.YELLOW));

		for (Casa casa : this.casasiniciais) {
			paintCasa(graphics, casa);
		}

		Casa br;

		/* desenho das casas horizontais */
		for (int x = 0; x < 15; x++) {
			for (int y = 6; y < 9; y++) {

				if (((x == 13) & (y == 6)) | ((x == 1) & (y == 8))) // pretas
					br = new Casa(x * boardWidth / 15, y * boardHeight / 15, boardWidth / 15, boardHeight / 15,
							Color.BLACK);

				else if (((y == 7) & (x > 0) & (x < 6)) | (x == 1 & y == 6))// vermelhas
					br = new Casa(x * boardWidth / 15, y * boardHeight / 15, boardWidth / 15, boardHeight / 15,
							Color.RED);

				else if (((y == 7) & (x > 8) & (x < 14)) | (x == 13 & y == 8))// amarelas
					br = new Casa(x * boardWidth / 15, y * boardHeight / 15, boardWidth / 15, boardHeight / 15,
							Color.YELLOW);

				else
					br = new Casa(x * boardWidth / 15, y * boardHeight / 15, boardWidth / 15, boardHeight / 15,
							Color.WHITE);

				this.casas.add(br);
				paintCasa(graphics, br);
			}
		}

		/* desenho das casas brancas verticais */

		for (int x = 6; x < 9; x++) {
			for (int y = 0; y < 15; y++) {
				if (((x == 6) & (y == 1)) | ((x == 8) & (y == 13)))// pretas
					br = new Casa(x * boardWidth / 15, y * boardHeight / 15, boardWidth / 15, boardHeight / 15,
							Color.BLACK);

				else if (((x == 7) & (y > 0) & (y < 6)) | (x == 8 & y == 1))// verdes
					br = new Casa(x * boardWidth / 15, y * boardHeight / 15, boardWidth / 15, boardHeight / 15,
							Color.GREEN);

				else if (((x == 7) & (y > 8) & (y < 14)) | (x == 6 & y == 13))// azuis
					br = new Casa(x * boardWidth / 15, y * boardHeight / 15, boardWidth / 15, boardHeight / 15,
							Color.BLUE);

				else
					br = new Casa(x * boardWidth / 15, y * boardHeight / 15, boardWidth / 15, boardHeight / 15,
							Color.WHITE);

				this.casas.add(br);
				paintCasa(graphics, br);
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

		this.retas.add(new Reta(xred, yred, Color.RED));
		this.retas.add(new Reta(xgreen, ygreen, Color.GREEN));
		this.retas.add(new Reta(xyellow, yyellow, Color.YELLOW));
		this.retas.add(new Reta(xblue, yblue, Color.BLUE));

		for (Reta reta : this.retas) {
			paintReta(graphics, reta);
		}
	}

	public void paintToken(Graphics2D graphics, Token token) {

		Ellipse2D circ = new Ellipse2D.Double(token.getX(), token.getY(), tokenRadius, tokenRadius);
		graphics.setPaint(token.getColor());
		graphics.fill(circ);
	}

	public void paintCasa(Graphics2D graphics, Casa casa) {

		// codigo de desenho das casas do jogo
		Rectangle2D casainicial = new Rectangle2D.Double(casa.getX(), casa.getY(), casa.getWidth(), casa.getHeigth());
		graphics.setPaint(Color.BLACK);
		graphics.draw(casainicial);
		graphics.setPaint(casa.getColor());
		graphics.fill(casainicial);
	}

	public void paintReta(Graphics2D graphics, Reta reta) {

		// codigo de desenho das casas do jogo
		graphics.setPaint(Color.BLACK);
		graphics.drawPolygon(reta.getX(), reta.getY(), 3);
		graphics.setPaint(reta.getColor());
		graphics.fillPolygon(reta.getX(), reta.getY(), 3);
	}
}
