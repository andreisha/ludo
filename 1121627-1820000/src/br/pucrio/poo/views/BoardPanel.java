package br.pucrio.poo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.pucrio.poo.controllers.BoardController;
import br.pucrio.poo.controllers.ColorController;
import br.pucrio.poo.controllers.PlayerWalkController;
import br.pucrio.poo.models.domain.PlayerColor;
import br.pucrio.poo.utils.IMoveObserver;
import br.pucrio.poo.utils.IObserver;
import br.pucrio.poo.views.board.Casa;
import br.pucrio.poo.views.board.Token;

public class BoardPanel extends JPanel implements IMoveObserver {
	private BoardPainter painter;
	private List<Token> tokens;
	private MouseListener mouseListener;
	private BoardController boardController;
	private PlayerWalkController playerController;
	private int boardWidth;
	private int boardHeight;

	public BoardPanel(int width, int height, int tokenRadius, BoardController boardController,
			PlayerWalkController playerWalkController) {
		this.painter = new BoardPainter(width, height, tokenRadius);
		this.tokens = new ArrayList<Token>();
		this.setPreferredSize(new Dimension(width, height));
		this.boardHeight = height;
		this.boardWidth = width;
		ColorController colorController = new ColorController();
		this.playerController = playerWalkController;
		this.boardController = boardController;
		boardController.registerObserver(this);

		this.mouseListener = new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				List<Casa> casas = painter.getCasas();

				for (Casa casa : casas) {
					if (x >= casa.getXMIN() && x <= casa.getXMAX() && y >= casa.getYMIN() && y <= casa.getYMAX()) {
						int i = tokens.size();

						for (int j = i - 1; j > -1; j--) {
							int tokenSpotNumber = tokens.get(j).getSpotNumber();
							int casaSpotNumber = casa.getNum();
							
							if (tokenSpotNumber == casaSpotNumber) {
								Color tokenColor = tokens.get(j).getColor();
								PlayerColor playerColor = colorController.getPlayerColorFromColor(tokenColor);
								
								if(!playerWalkController.isPlayerTurn(playerColor))
									continue;
								
								playerWalkController.playerWalk(playerColor,tokenSpotNumber);
								return;
							}
						}
						return;
					}
				}
			}
		};
		this.addMouseListener(mouseListener);
		updateView(null);
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public BoardController getBoardController() {
		return boardController;
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		painter.paintBoard((Graphics2D) graphics);
		paintTokens((Graphics2D) graphics);

	}

	public void repaint(List<Token> tokens) {
		this.tokens = tokens;

		this.repaint();
	}

	private void paintTokens(Graphics2D graphics) {
		int drawSpots[] = new int[tokens.size()];
		Color drawSpotsColor[] = new Color[tokens.size()];
		int j = 0;
		for (Token token : tokens) {
			boolean draw = true;
			int tokenSpot = token.getSpotNumber();
			Color tokenColor = token.getColor();

			for (int l = 0; l < tokens.size(); l++) {
				if (drawSpots[l] == tokenSpot) {
					if (drawSpotsColor[l] == tokenColor)
						token.paintTokenDouble(graphics, true);
					else
						token.paintTokenDouble(graphics, false);
					draw = false;
				}
			}
			if (!token.isEnabled())
				draw = false;

			if (draw == true) {
				token.paintToken(graphics);
				drawSpots[j] = token.getSpotNumber();
				drawSpotsColor[j] = token.getColor();
			}
			j++;
		}
	}

	@Override
	public void updateView(Object obj) {
		List<Token> tokens = boardController.getTokens();
		repaint(tokens);
	}
}