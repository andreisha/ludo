package br.pucrio.poo.models.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.annotations.Expose;
import br.pucrio.poo.models.BoardSpotsCalculations;

public class Game {

	private static final int SPOTS_QUANTITY = 56;
	private static final int RELATIVE_INITIAL_SPOT = 0;
	
	@Expose private static Game instance;
	@Expose private List<Player> players;
	@Expose private int currentIndex;
	@Expose private int boardWidth;
	@Expose private int boardHeight;
	@Expose private Pin lastPinAtRedInitialSpot;
	@Expose private Pin lastPinAtGreenInitialSpot;
	@Expose private Pin lastPinAtYellowInitialSpot;
	@Expose private Pin lastPinAtBlueInitialSpot;	
	private BoardSpotsCalculations boardSpotsCalculations;	
	
	private Game(List<Player> players, final int boardWidth, final int boardHeight) {

		this.currentIndex = 0;
		this.players = players;
		this.boardHeight = boardHeight;
		this.boardWidth = boardWidth;
		initializeBoardSpotsCalculations();
	}
	
	public void initializeBoardSpotsCalculations() {
		this.boardSpotsCalculations = new BoardSpotsCalculations(boardWidth, boardHeight);	
	}

	public Player currentPlayer() {
		return this.players.get(currentIndex);
	}

	public void endPlayerTurn() {
		currentIndex++;
		currentIndex %= players.size();
	}
	
	public static Game getInstance(final int boardWidth, final int boardHeight) {
		if (instance == null) {
			// initializing models
			List<Player> players = Arrays.asList(
					new Player(PlayerColor.RED.toString(), PlayerColor.RED, SPOTS_QUANTITY),
					new Player(PlayerColor.GREEN.toString(), PlayerColor.GREEN, SPOTS_QUANTITY),
					new Player(PlayerColor.YELLOW.toString(), PlayerColor.YELLOW, SPOTS_QUANTITY),
					new Player(PlayerColor.BLUE.toString(), PlayerColor.BLUE, SPOTS_QUANTITY));		
			 
	    	instance = new Game(players, boardWidth, boardHeight);
		}
		return instance;
	}
	
	public static void reset() {
		instance = null;	
	}

	public List<Player> getPlayers() {
		return new ArrayList<Player>(players);
	}
	
	public int getBoardHeight(){
		return this.boardHeight;
	}
	
	public int getBoardWidth() {
		return this.boardWidth;
	}
	
	public boolean isSpotEnabled(int spotNumber) {
		Player currentPlayer = this.currentPlayer();
		int relativeSpotNumber = boardSpotsCalculations.getRelativeSpotNumberFromSpotNumber(spotNumber, currentPlayer.getColor());
		Pin pinAtSpot = currentPlayer.getPinAtSpot(relativeSpotNumber);
		return pinAtSpot.isEnabled();
	}
	
	public boolean isInitialSpotBloqued() {
		return isSpotBloqued(RELATIVE_INITIAL_SPOT);
	}
	
	public boolean isSpotBloqued(int targetRelativeSpot) {
		int pinsAtTargetSpot = 0;		
		int targetSpot = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(targetRelativeSpot, currentPlayer().getColor());
		
		List<Player> players = getPlayers();
		for (Player player : players) {
			for (int relativeSpotNumber : player.getSpotNumbers()) {
				int spotNumber = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(relativeSpotNumber, player.getColor());
				
				if(spotNumber == targetSpot) {
					pinsAtTargetSpot++;
					
					if(pinsAtTargetSpot > 1)
						return true;
				}
			}
		}		
		return false;
	}
	
	private List<Pin> getPinsAtSpot(int targetSpot) {
		List<Pin> pinsAtTargetSpot = new ArrayList<Pin>();
		
		List<Player> players = getPlayers();
		for (Player player : players) {
			for (Pin pin : player.getPins()) {
				int relativeSpotNumber = pin.getSpotNumber();
				int spotNumber = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(relativeSpotNumber, player.getColor());
				
				if(spotNumber == targetSpot) {
					pinsAtTargetSpot.add(pin);
				}
			}
		}			
		return pinsAtTargetSpot;
	}
	
	public Player otherPlayerBlocking(int targetRelativeSpot, Player playerEating) {
		
		int targetSpot = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(targetRelativeSpot, currentPlayer().getColor());
		
		List<Player> players = getPlayers();
		for (Player player : players) {
			for (int relativeSpotNumber : player.getSpotNumbers()) {
				int spotNumber = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(relativeSpotNumber, player.getColor());
				
				if(spotNumber == targetSpot && player!= playerEating) {
					return player;
				}
			}
		}	
		return playerEating;
	}
	
	public Player getPlayerFromColor(PlayerColor color) {
		for (Player player : getPlayers()) {
			if(player.getColor() == color) 
				return player;
		}
		return null;
	}

	public boolean isPlayerTurn(PlayerColor color) {
		PlayerColor currentPlayerColor = currentPlayer().getColor();
		 return color == currentPlayerColor;
	}
	
	public boolean isHomeSpot(int spotNumber) {
		Player currentPlayer = this.currentPlayer();
		int relativeSpotNumber = boardSpotsCalculations.getRelativeSpotNumberFromSpotNumber(spotNumber, currentPlayer.getColor());
		return currentPlayer.isHomeSpot(relativeSpotNumber);
	}
	
	private Pin getLastPinAtInitial(PlayerColor color) {
		switch(color) {
			case RED:
				return lastPinAtRedInitialSpot;
			case GREEN:
				return lastPinAtGreenInitialSpot;
			case YELLOW:
				return lastPinAtYellowInitialSpot;
			case BLUE:
				return lastPinAtBlueInitialSpot;
			default:
				return null;
		}
	}	
	
	public Player getPlayerFromPin(Pin pin) {
		for (Player player: players) {
			List<Pin> pinsPlayer= player.getPins();
			for (Pin pinPlayer : pinsPlayer) {
				if (pin == pinPlayer)
					return player;
			}
		}
		return null;
	}
	
	public void openBarreira() {
		List<Integer> relativeSpotsOfBarreira = currentPlayer().spotsOfBarreira();
		for (int relativeSpot : relativeSpotsOfBarreira) {
			int spotNumber = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(relativeSpot, currentPlayer().getColor());
			if (canMove(spotNumber)) {
				movePlayer(spotNumber);
				return;
			}
		}
	}

	public boolean canLeaveHome() {
		Player currentPlayer = this.currentPlayer();
		
		if(!currentPlayer.canLeaveHome())
			return false;		
		
		if(isInitialSpotBloqued()) {
			return false;
		}		
		return true;
	}
	
	public void leaveHome() {
		tryEatAndMoveBeforeLeaveHome();				
		this.currentPlayer().leaveHome();		
	}

	public boolean canMove() {		
		Player currentPlayer = this.currentPlayer();
		List<Integer> currentPlayerSpotNumbers = currentPlayer.getSpotNumbers();		
		
		for (int relativeSpotNumber : currentPlayerSpotNumbers) {
			int spotNumber = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(relativeSpotNumber, currentPlayer.getColor());
			if (canMove(spotNumber)) 
				return true;			
		}				
		return false;
	}
	
	private void tryEatAndMoveBeforeLeaveHome(){
		Player currentPlayer = currentPlayer();
		int targetSpot = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(0, currentPlayer.getColor());
		List<Pin> pinsAtSpot = getPinsAtSpot(targetSpot);
		
		if(pinsAtSpot.size() == 1) {
			Pin pinEaten = getLastPinAtInitial(currentPlayer.getColor());
			Player playerEaten = getPlayerFromColor(pinEaten.getPlayerColor());
			playerEaten.goToHome(pinEaten);
			
			List<Pin> pinsPlayer = currentPlayer.getPins();
			for (Pin pin : pinsPlayer) {
				int spotPin = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(pin.getSpotNumber(), currentPlayer.getColor());

				if (canMove(spotPin, 6)) {
					currentPlayer.goForward(pin.getSpotNumber(), 6);
					return;
				}					
			}
		}		
	}
	
	public boolean canPlayAgain() {
		return this.currentPlayer().canPlayAgain();
	}
	
	public boolean casaPreta (int targetRelativeSpot) {
		int targetSpot = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(targetRelativeSpot, currentPlayer().getColor());

		if ((targetSpot == 10) || (targetSpot == 23) || (targetSpot == 36) ||(targetSpot == 49)) {
			return true;
		}
		
		return false;
	}
	
	public boolean casaInicial (int targetRelativeSpot) {
		int targetSpot = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(targetRelativeSpot, currentPlayer().getColor());

		if ((targetSpot == 1) || (targetSpot == 14) || (targetSpot == 27) ||(targetSpot == 40)) {
			return true;
		}
		
		return false;
	}
	
	private int getDistancia(Player player) {		
		int distanciaPlayer = 0;
		List<Pin> pinPlayer = player.getPins();
		for (Pin pin : pinPlayer) {
			if (pin.isEnabled()) {
				int relativeSpotNumber = pin.getSpotNumber();
				if (relativeSpotNumber < 0 ) 
					relativeSpotNumber = -1;
				int distanciaPin = 56 - relativeSpotNumber;
				distanciaPlayer += distanciaPin;
			}
		}
		return distanciaPlayer;
	}
	
	private List<Player> classificacoes() {
		List<Integer> distanciasPlayers = new ArrayList<Integer>();
		SortedMap<Integer, Player> distanciasMap = new TreeMap<Integer, Player>();
		for (Player player : players) {
			int distanciaPlayer = getDistancia(player);
			for (int distancia : distanciasPlayers) {
				if (distancia == distanciaPlayer)
					distanciaPlayer++;
			}
			distanciasMap.put(distanciaPlayer, player);
			distanciasPlayers.add(distanciaPlayer);
			List<Pin> pinPlayer = player.getPins();
			for (Pin pin : pinPlayer) {
				if (pin.isEnabled()) {
					pin.disenable();
				}
			}
		}
		List<Player> classificacoes = new ArrayList<Player>();
		for (Map.Entry<Integer, Player> entry : distanciasMap.entrySet()) {
		    classificacoes.add(entry.getValue()); 
		}		
		return classificacoes;
	}
	
	public boolean hasBarreira(int relativeSpotNumber, int steps) {
		int targetRelativeSpot = relativeSpotNumber + steps;
		
		for (int path = relativeSpotNumber + 1; path < targetRelativeSpot +1 ; path++) {
			if(isSpotBloqued(path)) {				
				int spot = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(path, currentPlayer().getColor());
				List<Pin> pinsAtSpot = getPinsAtSpot(spot);				
				if(pinsAtSpot.size() == 2 && (pinsAtSpot.get(0).getPlayerColor() == pinsAtSpot.get(1).getPlayerColor()))
					return true;
			}
		}
		return false;
	}
	
	public boolean canMove(int spotNumber) {
		Player currentPlayer = this.currentPlayer();
		int steps = currentPlayer.getDicePoints();		
		return canMove(spotNumber, steps);
	}
	
	private boolean canMove(int spotNumber, int steps) {
		Player currentPlayer = this.currentPlayer();
		int relativeSpotNumber = boardSpotsCalculations.getRelativeSpotNumberFromSpotNumber(spotNumber, currentPlayer.getColor());
		
		if (!currentPlayer.canMove(relativeSpotNumber)) 
			return false;
		
		int targetRelativeSpot = relativeSpotNumber + steps;		
		if (targetRelativeSpot > SPOTS_QUANTITY)
			return false;
		
		if(hasBarreira(relativeSpotNumber,steps))
			return false;
		
		if(isSpotBloqued(targetRelativeSpot))
			return false;
		
		if(casaInicial(targetRelativeSpot) && HasPlayerAnotherPinAtSpot(targetRelativeSpot))
			return false;		
		
		//if (casaPreta(targetRelativeSpot) && !isSpotBloqued(targetRelativeSpot))
			//return true;		
		
		return true;
	}
	
	private boolean HasPlayerAnotherPinAtSpot(int targetRelativeSpot) {
		int targetSpot = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(targetRelativeSpot, currentPlayer().getColor());
		List<Pin> pinsAtSpot = getPinsAtSpot(targetSpot);
		if(pinsAtSpot.size() == 1 && pinsAtSpot.get(0).getPlayerColor() == currentPlayer().getColor())
			return true;
		
		return false;
	}
	
	private boolean tryMoveAnyPin(int steps) {
		Player currentPlayer = currentPlayer();
		List<Pin> pinsPlayer = currentPlayer.getPins();
		for (Pin pin : pinsPlayer) {
			int spotPin = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(pin.getSpotNumber(), currentPlayer.getColor());

			if (canMove(spotPin, steps)) {
				currentPlayer.goForward(pin.getSpotNumber(), steps);
				return true;
			}					
		}
		return false;
	}
	
	public void movePlayer(int spotNumber) {
		goForward(spotNumber);
		
		if(tryEatAndMoveAfterMovement())
			return;
		
		if(moveIfLastPinReachedEnd())
			return;
		
		setLastPinAtInitial();		

		if (canGameFinalize()) 
			finalizeGame();		
		return;
	}	
	
	private boolean tryEatAndMoveAfterMovement() {
		Player player = currentPlayer();
		int relativeSpotAfterSteps = player.getLastPinPlayed().getSpotNumber();
		int spotAfterSteps = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(relativeSpotAfterSteps, player.getColor());
				
		if (isSpotBloqued(relativeSpotAfterSteps) && !casaPreta(relativeSpotAfterSteps) && !casaInicial(relativeSpotAfterSteps)) {
			Player playerEaten = otherPlayerBlocking(relativeSpotAfterSteps, player);
			if (playerEaten != player) {
				int spotEaten = boardSpotsCalculations.getRelativeSpotNumberFromSpotNumber(spotAfterSteps, playerEaten.getColor());
	
				Pin pinEaten = playerEaten.getPinAtSpot(spotEaten);
				playerEaten.goToHome(pinEaten);				
				boolean moved = tryMoveAnyPin(6);				
				if(moved)
					return true;
			}
		}
		return false;
	}
	
	private boolean moveIfLastPinReachedEnd() {
		if (!currentPlayer().getLastPinPlayed().isEnabled()) {
			boolean moved = tryMoveAnyPin(6);			
			if(moved)
				return true;
		}
		return false;
	}
	
	private void goForward(int spotNumber) {
		Player player = this.currentPlayer();
		int relativeSpotNumber = boardSpotsCalculations.getRelativeSpotNumberFromSpotNumber(spotNumber, player.getColor());
		player.goForward(relativeSpotNumber);	
	}
	
	private void setLastPinAtInitial() {
		Player player = currentPlayer();
		int relativeSpotAfterMovement = player.getLastPinPlayed().getSpotNumber();
		int spotAfterMovement = boardSpotsCalculations.getSpotNumberFromRelativeSpotNumber(relativeSpotAfterMovement, currentPlayer().getColor());
		
		switch (spotAfterMovement) {
			case(1):
				if (currentPlayer().getColor() != PlayerColor.RED)
					lastPinAtRedInitialSpot = currentPlayer().getLastPinPlayed();
				break;
			case(14):
				if (currentPlayer().getColor() != PlayerColor.GREEN)
					lastPinAtGreenInitialSpot = currentPlayer().getLastPinPlayed();
				break;
			case(27):
				if (currentPlayer().getColor() != PlayerColor.YELLOW)
					lastPinAtYellowInitialSpot = currentPlayer().getLastPinPlayed();
				break;
			case(40):
				if (currentPlayer().getColor() != PlayerColor.BLUE)
					lastPinAtBlueInitialSpot = currentPlayer().getLastPinPlayed();
				break;
			default:
				break;
		}	
	}
	
	private boolean canGameFinalize() {
		if (currentPlayer().getNumberPlayerSucceed() == 4) 
			return true;
		return false;					
	}
	
	private void finalizeGame(){
		currentPlayer().finalizeGame(classificacoes());
	}
}


