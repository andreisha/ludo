package br.pucrio.poo.controllers;

import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.views.OperationsPanel;
import br.pucrio.poo.views.buttons.LoadGameButton;
import br.pucrio.poo.views.buttons.NewGameButton;
import br.pucrio.poo.views.buttons.SaveGameButton;

public class OperationsController {

	private LoadGameController loadGameController;
	private NewGameController newGameController;
	private SaveGameController saveGameController;
	private NewGameButton newGameButton;
	private LoadGameButton loadGameButton;
	private SaveGameButton saveGameButton;

	public OperationsController(OperationsPanel operationsPanel, LoadGameController loadGameController,
			NewGameController newGameController, SaveGameController saveGameController) {
		this.loadGameButton = operationsPanel.getLoadGameButton();
		this.newGameButton = operationsPanel.getNewGameButton();
		this.saveGameButton = operationsPanel.getSaveGameButton();
		this.saveGameController = saveGameController;
		this.newGameController = newGameController;
		this.loadGameController = loadGameController;
	}

	public void enableTo(Player player) {

		this.loadGameButton.setEnabled(false);
		this.newGameButton.setEnabled(false);
		this.saveGameButton.setEnabled(false);
	}
}
