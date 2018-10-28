package br.pucrio.poo.controllers.spot;

import br.pucrio.poo.controllers.TurnFinalizerController;
import br.pucrio.poo.models.domain.Player;

public class DoNothingSpotController implements SpotController {

	@Override
	public void activatedBy(Player player, TurnFinalizerController turnFinalizer) {
		turnFinalizer.finalizeTurn();
	}
}
