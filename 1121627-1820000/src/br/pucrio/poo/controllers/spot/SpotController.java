package br.pucrio.poo.controllers.spot;

import br.pucrio.poo.controllers.TurnFinalizerController;
import br.pucrio.poo.models.domain.Player;

public interface SpotController {
	public void activatedBy(Player player, TurnFinalizerController turnFinalizer);
}
