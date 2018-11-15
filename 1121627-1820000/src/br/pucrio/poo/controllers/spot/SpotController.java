package br.pucrio.poo.controllers.spot;

import java.util.List;

import br.pucrio.poo.controllers.TurnFinalizerController;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.views.board.Casa;

public interface SpotController {
	public void activatedBy(Player player, TurnFinalizerController turnFinalizer, List<Casa> casas);
}
