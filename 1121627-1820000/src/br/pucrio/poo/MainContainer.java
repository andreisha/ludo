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

	public static void main(String[] args) throws Exception {
		Game game = Game.getInstance(BOARD_WIDTH, BOARD_HEIGHT);

		// initializing controllers
		BoardController boardController = BoardController.getInstance(game);
		TurnFinalizerController turnFinalizer = TurnFinalizerController.getInstance(boardController, game);
		PlayerWalkController playerWalkController = PlayerWalkController.getInstance(turnFinalizer, game);
		DicesController dicesController = DicesController.getInstance(game, playerWalkController);		
		OperationsController operationsController = OperationsController.getInstance();
		TurnInitializerController turnInitializer = TurnInitializerController.getInstance(dicesController, operationsController);
		turnFinalizer.setTurnInitializer(turnInitializer);

		// initializing views		
		BoardPanel boardPanel = new BoardPanel(BOARD_WIDTH, BOARD_HEIGHT,TOKEN_RADIUS, boardController, playerWalkController);
		DicesPanel dicesPanel = new DicesPanel(dicesController, playerWalkController);
		OperationsPanel operationsPanel = new OperationsPanel();
		MainWindow window = new MainWindow(boardPanel, dicesPanel, operationsPanel);
		
		turnInitializer.startTurnOf(game.currentPlayer());
		window.setVisible(true);
	}
}