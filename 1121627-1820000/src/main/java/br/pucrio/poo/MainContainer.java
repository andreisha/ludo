package br.pucrio.poo;
import br.pucrio.poo.views.BoardPainter;
import br.pucrio.poo.views.BoardPanel;
import br.pucrio.poo.views.MainWindow;
import br.pucrio.poo.views.OperationsPanel;

public class MainContainer {

	private static final int TOKEN_RADIUS = 10;	
	private static final int BOARD_WIDTH = 400;
	private static final int BOARD_HEIGHT = 401;
	
	public static void main(String[] args) {
		
		// initializing views
		BoardPainter painter = new BoardPainter(BOARD_WIDTH, BOARD_HEIGHT, TOKEN_RADIUS);
		BoardPanel boardPanel = new BoardPanel(painter, BOARD_WIDTH, BOARD_HEIGHT);
		OperationsPanel operationsPanel = new OperationsPanel();
//		DicesPanel dicesPanel = new DicesPanel();	
		
		MainWindow window = new MainWindow(boardPanel, operationsPanel);	
		window.setVisible(true);
		
	}
}
