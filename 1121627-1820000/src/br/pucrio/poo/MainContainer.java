package br.pucrio.poo;

import br.pucrio.poo.controllers.BoardController;
import br.pucrio.poo.controllers.DicesController;
import br.pucrio.poo.controllers.LoadGameController;
import br.pucrio.poo.controllers.NewGameController;
import br.pucrio.poo.controllers.OperationsController;
import br.pucrio.poo.controllers.PlayerWalkController;
import br.pucrio.poo.controllers.SaveGameController;
import br.pucrio.poo.controllers.TurnFinalizerController;
import br.pucrio.poo.controllers.TurnInitializerController;
import br.pucrio.poo.models.domain.Board;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.DicesPanel;
import br.pucrio.poo.views.MainWindow;
import br.pucrio.poo.views.OperationsPanel;

public class MainContainer {

	private static final int TOKEN_RADIUS = 5;
	private static final int BOARD_WIDTH = 500;
	private static final int BOARD_HEIGHT = 500;

	public static void main(String[] args) {
		Game game = Game.getInstance(BOARD_WIDTH, BOARD_HEIGHT);

		// initializing controllers
		BoardController boardController = new BoardController(game, BOARD_WIDTH, BOARD_HEIGHT);
		TurnFinalizerController turnFinalizer = new TurnFinalizerController(boardController, game);
		PlayerWalkController walkController = new PlayerWalkController(boardController, turnFinalizer, game);
		DicesController dicesController = new DicesController(game, walkController, turnFinalizer);

		NewGameController newGameController = new NewGameController();
		LoadGameController loadGameController = new LoadGameController();
		SaveGameController saveGameController = new SaveGameController();
		OperationsController operationsController = new OperationsController(loadGameController, newGameController,
				saveGameController);

		TurnInitializerController turnInitializer = new TurnInitializerController(dicesController,
				operationsController);
		turnFinalizer.setTurnInitializer(turnInitializer);

		// initializing views		
		BoardPanel boardPanel = new BoardPanel(BOARD_WIDTH, BOARD_HEIGHT,TOKEN_RADIUS, boardController, walkController);
		DicesPanel dicesPanel = new DicesPanel(dicesController);
		OperationsPanel operationsPanel = new OperationsPanel();
		MainWindow window = new MainWindow(boardPanel, dicesPanel, operationsPanel);
		
		turnInitializer.startTurnOf(game.currentPlayer());
		window.setVisible(true);
	}
}
