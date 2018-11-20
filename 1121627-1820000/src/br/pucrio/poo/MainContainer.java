package br.pucrio.poo;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.poo.controllers.BoardController;
import br.pucrio.poo.controllers.ColorController;
import br.pucrio.poo.controllers.DicesController;
import br.pucrio.poo.controllers.LoadGameController;
import br.pucrio.poo.controllers.NewGameController;
import br.pucrio.poo.controllers.OperationsController;
import br.pucrio.poo.controllers.PlayerWalkController;
import br.pucrio.poo.controllers.SaveGameController;
import br.pucrio.poo.controllers.TurnFinalizerController;
import br.pucrio.poo.controllers.TurnInitializerController;
import br.pucrio.poo.controllers.spot.SpotController;
import br.pucrio.poo.controllers.spot.SpotFrontController;
import br.pucrio.poo.models.BoardSpotsCalculations;
import br.pucrio.poo.models.TokenPositionCalculator;
import br.pucrio.poo.models.domain.Board;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.views.BoardPainter;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.DicesPainter;
import br.pucrio.poo.views.DicesPanel;
import br.pucrio.poo.views.MainWindow;
import br.pucrio.poo.views.OperationsPanel;
import br.pucrio.poo.views.board.TokenFactory;

public class MainContainer {

	private static final int TOKEN_RADIUS = 5;
	private static final int BOARD_WIDTH = 500;
	private static final int BOARD_HEIGHT = 500;

	public static void main(String[] args) {
		Game game = Game.getInstance(BOARD_WIDTH, BOARD_HEIGHT);
		Board board = game.getBoard();

		BoardSpotsCalculations spotsCalculation = new BoardSpotsCalculations(BOARD_WIDTH, BOARD_HEIGHT);
		TokenPositionCalculator tokenCalculator = new TokenPositionCalculator(spotsCalculation);

		// initializing views
		BoardPainter painter = new BoardPainter(BOARD_WIDTH, BOARD_HEIGHT, TOKEN_RADIUS);
		//BoardPanel boardPanel = new BoardPanel(painter, BOARD_WIDTH, BOARD_HEIGHT,tokenCalculator,walkController,colorController);
		BoardPanel boardPanel = new BoardPanel(painter, BOARD_WIDTH, BOARD_HEIGHT,tokenCalculator);
		OperationsPanel operationsPanel = new OperationsPanel();
		DicesPainter dicesPainter = new DicesPainter();
		DicesPanel dicesPanel = new DicesPanel();

		MainWindow window = new MainWindow(boardPanel, dicesPanel, operationsPanel);

		// initializing controllers
		ColorController colorController = new ColorController();
		NewGameController newGameController = new NewGameController();
		newGameController.startNewGame(BOARD_WIDTH, BOARD_HEIGHT);
		TokenFactory tokenFactory = new TokenFactory(BOARD_WIDTH/30);
		BoardController boardController = new BoardController(game, tokenCalculator, boardPanel, colorController,tokenFactory);

		TurnFinalizerController turnFinalizer = new TurnFinalizerController(boardController, game);
		SpotFrontController spotFrontController = new SpotFrontController(new ArrayList<SpotController>());
		PlayerWalkController walkController = new PlayerWalkController(boardController, turnFinalizer,spotFrontController, game);
		DicesController dicesController = new DicesController(dicesPanel, walkController, turnFinalizer);

		LoadGameController loadGameController = new LoadGameController();
		
		SaveGameController saveGameController = new SaveGameController();
		OperationsController operationsController = new OperationsController(operationsPanel, loadGameController,
				newGameController, saveGameController);

		TurnInitializerController turnInitializer = new TurnInitializerController(dicesController,
				operationsController);
		turnFinalizer.setTurnInitializer(turnInitializer);

		window.setVisible(true);
		boardController.update();
		turnInitializer.startTurnOf(game.currentPlayer());
	}
}
