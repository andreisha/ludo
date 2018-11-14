package br.pucrio.poo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import br.pucrio.poo.controllers.spot.SpotFrontController;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.views.board.CasaJogo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PlayerWalkController {

	private BoardController boardController;
	private TurnFinalizerController turnFinalizer;
	private SpotFrontController spotFrontController;
	private MouseListener mouseListener;
	private MouseEvent mouseEvent;
	
	public PlayerWalkController(BoardController boardController, TurnFinalizerController turnFinalizer,
			SpotFrontController spotFrontController) {
		this.boardController = boardController;
		this.turnFinalizer = turnFinalizer;
		this.spotFrontController = spotFrontController;
	}

	public void playerWalk(Player player) {
		int steps = player.getDicePoints();
		
		boardController.getMouseClic(this, player, steps);
		
		
		//this.spotFrontController.spotActivatedBy(player, turnFinalizer);
	}
	public void playerWalkOk(Player player, List<CasaJogo> casas) {
		int steps = player.getDicePoints();

		player.goForward(steps, casas);
		boardController.update(casas);
		
			}
}
