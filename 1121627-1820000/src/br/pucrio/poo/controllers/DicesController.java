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

	public void enableRolling(Player player, List<Casa> casas) {
		dicesPanel.enableTo(player, this, casas);
	}

	public void roll(Player player, List<Casa> casas) {

		try {
			player.rollDices();
			this.dicesPanel.setDiceOneNumber(player.getDiceOne().toString());
			
			showResults(player);

			this.dicesPanel.disablePanel();

			if (player.exceedContinuedRoll()) {
				turnFinalizer.finalizeTurn(casas);
			} else {
				walkController.playerWalk(player, casas);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showResults(Player player) {
		int dice1Result = player.getDiceOneResult();
		dicesPanel.repaint(getDiceImage(dice1Result));
	}
	
	private Image getDiceImage(int value) {
		return Resources.getDiceImage(value);
	}
}
