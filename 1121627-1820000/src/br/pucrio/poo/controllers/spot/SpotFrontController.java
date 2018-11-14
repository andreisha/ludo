package br.pucrio.poo.controllers.spot;

import java.util.List;

import br.pucrio.poo.controllers.TurnFinalizerController;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.views.board.CasaJogo;

public class SpotFrontController {
	private List<SpotController> spotControllers;

	public SpotFrontController(List<SpotController> spotControllers) {
		this.spotControllers = spotControllers;
	}

	public void spotActivatedBy(Player player, TurnFinalizerController turnFinalizer, List<CasaJogo> casas) {
		spotControllers.get(player.getSpotNumber()).activatedBy(player, turnFinalizer, casas);
	}
}
