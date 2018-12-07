package br.pucrio.poo;

import br.pucrio.poo.controllers.BoardController;
import br.pucrio.poo.controllers.DicesController;
import br.pucrio.poo.controllers.PlayerWalkController;
import br.pucrio.poo.controllers.TurnFinalizerController;
import br.pucrio.poo.controllers.TurnInitializerController;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.utils.Serializer;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.DicesPanel;
import br.pucrio.poo.views.MainWindow;
import br.pucrio.poo.views.OperationsPanel;
import br.pucrio.poo.utils.Register;;

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
		TurnInitializerController turnInitializer = TurnInitializerController.getInstance(dicesController);
		turnFinalizer.setTurnInitializer(turnInitializer);

		// initializing views		
		BoardPanel boardPanel = new BoardPanel(BOARD_WIDTH, BOARD_HEIGHT,TOKEN_RADIUS, boardController, playerWalkController);
		DicesPanel dicesPanel = new DicesPanel(dicesController, playerWalkController);
		
		Register register = Register.getInstance(boardPanel, dicesPanel);
		Serializer serializer = Serializer.getInstance(game, register);
		
		OperationsPanel operationsPanel = new OperationsPanel(serializer);
		MainWindow window = new MainWindow(boardPanel, dicesPanel, operationsPanel);
		
		turnInitializer.startTurnOf(game.currentPlayer());
		window.setVisible(true);
	}
}