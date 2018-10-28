package br.pucrio.poo.controllers;

import java.awt.Image;

import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.models.utils.Resources;
import br.pucrio.poo.views.DicesPanel;

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
			this.dicesPanel.setDiceOneNumber(player.getDiceOne().toString());
			this.dicesPanel.setDiceTwoNumber(player.getDiceTwo().toString());
			
			showResults(player);

			this.dicesPanel.disablePanel();

			if (player.exceedContinuedRoll()) {
				turnFinalizer.finalizeTurn();
			} else {
				walkController.playerWalk(player);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showResults(Player player) {
		int dice1Result = player.getDiceOneResult();
		int dice2Result = player.getDiceTwoResult();
		dicesPanel.repaint(getDiceImage(dice1Result), getDiceImage(dice2Result));
	}
	
	private Image getDiceImage(int value) {
		return Resources.getDiceImage(value);
	}
}
