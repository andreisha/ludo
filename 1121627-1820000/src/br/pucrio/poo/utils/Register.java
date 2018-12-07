package br.pucrio.poo.utils;
import br.pucrio.poo.controllers.BoardController;
import br.pucrio.poo.controllers.DicesController;
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
		BoardController BoardController = boardPanel.getBoardController();
		DicesController DicesController = dicesPanel.getDicesController();
		
		BoardController.setGame(game);
		DicesController.setGame(game);
		
		BoardController.registerObserver(this.boardPanel);
		DicesController.registerEnableToObserver(this.dicesPanel);
		DicesController.registerObserver(this.dicesPanel);		
	}
}
