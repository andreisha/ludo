package br.pucrio.poo.utils;
import br.pucrio.poo.controllers.BoardController;
import br.pucrio.poo.controllers.DicesController;
import br.pucrio.poo.controllers.PlayerWalkController;
import br.pucrio.poo.controllers.TurnFinalizerController;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.DicesPanel;

public class Register {
	private static Register instance;
	private BoardPanel boardPanel;
	private DicesPanel dicesPanel;
	
	private Register(BoardPanel boardPanel,DicesPanel dicesPanel ) {
		this.boardPanel = boardPanel;
		this.dicesPanel = dicesPanel;
	}
	
	public static Register getInstance(BoardPanel boardPanel,DicesPanel dicesPanel) {
		if (instance == null) {			 
	    	instance = new Register(boardPanel,dicesPanel);
		}
		return instance;
	}
	
	public void registerObservers(Game game) {
		BoardController boardController = boardPanel.getBoardController();
		DicesController dicesController = dicesPanel.getDicesController();
		PlayerWalkController playerWalkController = dicesController.getPlayerWalkController();
		TurnFinalizerController turnFinalizerController = playerWalkController.getTurnFinalizerController();
		
		boardController.setGame(game);
		dicesController.setGame(game);
		playerWalkController.setGame(game);
		turnFinalizerController.setGame(game);	
		
		boardController.registerObserver(this.boardPanel);
		dicesController.registerEnableToObserver(this.dicesPanel);
		dicesController.registerObserver(this.dicesPanel);		
	}
}
