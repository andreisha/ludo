package br.pucrio.poo.controllers;

import java.awt.Image;
import java.util.List;

import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.utils.Resources;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.DicesPanel;
import br.pucrio.poo.views.board.Casa;

public class DicesController {

	private DicesPanel dicesPanel;
	private PlayerWalkController walkController;
	private TurnFinalizerController turnFinalizer;

	public DicesController(DicesPanel dicesPanel, PlayerWalkController walkController,
			TurnFinalizerController turnFinalizer) {

		this.dicesPanel = dicesPanel;
		this.walkController = walkController;
		this.turnFinalizer = turnFinalizer;
	}

	public void enableRolling(Player player) {
		dicesPanel.enableTo(player, this);
	}

	public void roll(Player player) {

		try {
			player.rollDices();			
			showResults(player);
			this.dicesPanel.disablePanel();// implementar observable

			if (player.exceedContinuedRoll()) {
				turnFinalizer.finalizeTurn();
			} else {
				//walkController.playerWalk(player);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showResults(Player player) {
		int dice1Result = player.getDiceResult();
		dicesPanel.repaint(getDiceImage(dice1Result));// implementar observable
	}
	
	private Image getDiceImage(int value) {
		return Resources.getDiceImage(value);
	}
}
