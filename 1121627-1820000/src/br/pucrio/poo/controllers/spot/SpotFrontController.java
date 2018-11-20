package br.pucrio.poo.controllers.spot;

import java.util.List;

import br.pucrio.poo.controllers.TurnFinalizerController;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.views.board.Casa;

public class SpotFrontController {
	private List<SpotController> spotControllers;

	public SpotFrontController(List<SpotController> spotControllers) {
		this.spotControllers = spotControllers;
	}

	public void spotActivatedBy(Player player, TurnFinalizerController turnFinalizer) {
		//spotControllers.get(player.getSpotNumber()).activatedBy(player, turnFinalizer);
		spotControllers.get(0).activatedBy(player, turnFinalizer);
	}
}
