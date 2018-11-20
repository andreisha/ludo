package br.pucrio.poo.models;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.pucrio.poo.models.domain.PlayerColor;

public class BoardSpotsCalculations {
	
	private double boardWidth;
	private double boardHeight;
	Map<Integer,Position> positionMap;
	Integer[] redCircuit; 
	Integer[] greenCircuit; 
	Integer[] yellowCircuit;
	Integer[] blueCircuit;

	public BoardSpotsCalculations(double boardWidth, double boardHeight) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.positionMap =new HashMap<Integer,Position>();
		InitializeMaps();		
	}
	
	public Position getSpotPosition(int relativeSpotNumber, PlayerColor color) {
		switch (color) {
		case RED:
			return positionMap.get(redCircuit[relativeSpotNumber]);
		case BLUE:
			return positionMap.get(blueCircuit[relativeSpotNumber]);
		case GREEN:
			return positionMap.get(greenCircuit[relativeSpotNumber]);
		case YELLOW:
			return positionMap.get(yellowCircuit[relativeSpotNumber]);
		default:
			return null;
		}
	}
	
	public int getSpotNumber(int relativeSpotNumber, PlayerColor color) {
		switch (color) {
		case RED:
			return redCircuit[relativeSpotNumber];
		case BLUE:
			return blueCircuit[relativeSpotNumber];
		case GREEN:
			return greenCircuit[relativeSpotNumber];
		case YELLOW:
			return yellowCircuit[relativeSpotNumber];
		default:
			return 0;
		}
	}
	
	private void InitializeMaps() {
		InitializePositionMap();
		InitializeRedCircuit();
		InitializeGreenCircuit();
		InitializeYellowCircuit();
		InicializeBlueCircuit();
	}

	private void InitializeRedCircuit() {
		redCircuit = new Integer[]{72,73,74,75, //casas iniciais
				                   1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				                  11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
				                  21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
				                  31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
				                  41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
				                  51, 52, 53, 54, 55, 56}; 
	}
	
	private void InitializeGreenCircuit() {
		greenCircuit = new Integer[] {76,77,78,79,//casas iniciais
				14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                57, 58, 59, 60, 61};
	}
	
	private void InitializeYellowCircuit() {
		yellowCircuit = new Integer[] { 80,81,82,83, //casas iniciais
				27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
                11, 12,13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 62, 63, 64, 65, 66};		
	}	
	
	private void InicializeBlueCircuit() {
		blueCircuit = new Integer[] {84,85,86,87, 
				40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
                11, 12,13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25,26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 67, 68,
                69, 70, 71};// 4 últimos são as casas iniciais
	}
	
	private void InitializePositionMap(){
		
		positionMap.put(0, new Position(0,6 * boardHeight / 15));
		positionMap.put(1, new Position(boardWidth / 15,6 * boardHeight / 15));
		positionMap.put(2, new Position(2*boardWidth / 15,6 * boardHeight / 15));
		positionMap.put(3, new Position(3*boardWidth / 15,6 * boardHeight / 15));
		positionMap.put(4, new Position(4*boardWidth / 15,6 * boardHeight / 15));
		positionMap.put(5, new Position(5*boardWidth / 15,6 * boardHeight / 15));
		positionMap.put(6, new Position(6*boardWidth / 15,5 * boardHeight / 15));
		positionMap.put(7, new Position(6*boardWidth / 15,4 * boardHeight / 15));
		positionMap.put(8, new Position(6*boardWidth / 15,3 * boardHeight / 15));
		positionMap.put(9, new Position(6*boardWidth / 15,2 * boardHeight / 15));
		positionMap.put(10, new Position(6*boardWidth / 15,1 * boardHeight / 15));
		positionMap.put(11, new Position(6*boardWidth / 15,0));
		positionMap.put(12, new Position(7*boardWidth / 15,0));
		positionMap.put(13, new Position(8*boardWidth / 15,0));
		positionMap.put(14, new Position(8*boardWidth / 15,1* boardHeight / 15));
		positionMap.put(15, new Position(8*boardWidth / 15,2* boardHeight / 15));
		positionMap.put(16, new Position(8*boardWidth / 15,3* boardHeight / 15));
		positionMap.put(17, new Position(8*boardWidth / 15,4* boardHeight / 15));
		positionMap.put(18, new Position(8*boardWidth / 15,5* boardHeight / 15));
		positionMap.put(19, new Position(9*boardWidth / 15,6* boardHeight / 15));
		positionMap.put(20, new Position(10*boardWidth / 15,6* boardHeight / 15));
		positionMap.put(21, new Position(11*boardWidth / 15,6* boardHeight / 15));
		positionMap.put(22, new Position(12*boardWidth / 15,6* boardHeight / 15));
		positionMap.put(23, new Position(13*boardWidth / 15,6* boardHeight / 15));
		positionMap.put(24, new Position(14*boardWidth / 15,6* boardHeight / 15));
		positionMap.put(25, new Position(14*boardWidth / 15,7* boardHeight / 15));
		positionMap.put(26, new Position(14*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(27, new Position(13*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(28, new Position(12*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(29, new Position(11*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(30, new Position(10*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(31, new Position(9*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(32, new Position(8*boardWidth / 15,9* boardHeight / 15));
		positionMap.put(33, new Position(8*boardWidth / 15,10* boardHeight / 15));
		positionMap.put(34, new Position(8*boardWidth / 15,11* boardHeight / 15));
		positionMap.put(35, new Position(8*boardWidth / 15,12* boardHeight / 15));
		positionMap.put(36, new Position(8*boardWidth / 15,13* boardHeight / 15));
		positionMap.put(37, new Position(8*boardWidth / 15,14* boardHeight / 15));
		positionMap.put(38, new Position(7*boardWidth / 15,14* boardHeight / 15));
		positionMap.put(39, new Position(6*boardWidth / 15,14* boardHeight / 15));
		positionMap.put(40, new Position(6*boardWidth / 15,13* boardHeight / 15));
		positionMap.put(41, new Position(6*boardWidth / 15,12* boardHeight / 15));
		positionMap.put(42, new Position(6*boardWidth / 15,11* boardHeight / 15));
		positionMap.put(43, new Position(6*boardWidth / 15,10* boardHeight / 15));
		positionMap.put(44, new Position(6*boardWidth / 15,9* boardHeight / 15));
		positionMap.put(45, new Position(5*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(46, new Position(4*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(47, new Position(3*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(48, new Position(2*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(49, new Position(1*boardWidth / 15,8* boardHeight / 15));
		positionMap.put(50, new Position(0,8* boardHeight / 15));
		positionMap.put(51, new Position(0,7* boardHeight / 15));
		positionMap.put(52, new Position(1*boardWidth / 15,7*boardWidth / 15));
		positionMap.put(53, new Position(2*boardWidth / 15,7*boardWidth / 15));
		positionMap.put(54, new Position(3*boardWidth / 15,7*boardWidth / 15));
		positionMap.put(55, new Position(4*boardWidth / 15,7*boardWidth / 15));
		positionMap.put(56, new Position(5*boardWidth / 15,7*boardWidth / 15));
		positionMap.put(57, new Position(7*boardWidth / 15,1*boardWidth / 15));
		positionMap.put(58, new Position(7*boardWidth / 15,2*boardWidth / 15));
		positionMap.put(59, new Position(7*boardWidth / 15,3*boardWidth / 15));
		positionMap.put(60, new Position(7*boardWidth / 15,4*boardWidth / 15));
		positionMap.put(61, new Position(7*boardWidth / 15,5*boardWidth / 15));
		positionMap.put(62, new Position(13*boardWidth / 15,7*boardHeight / 15));
		positionMap.put(63, new Position(12*boardWidth / 15,7*boardHeight / 15));
		positionMap.put(64, new Position(11*boardWidth / 15,7*boardHeight / 15));
		positionMap.put(65, new Position(10*boardWidth / 15,7*boardHeight / 15));
		positionMap.put(66, new Position(9*boardWidth / 15,7*boardHeight / 15));
		positionMap.put(67, new Position(7*boardHeight / 15,13*boardWidth / 15));
		positionMap.put(68, new Position(7*boardHeight / 15,12*boardWidth / 15));
		positionMap.put(69, new Position(7*boardHeight / 15,11*boardWidth / 15));
		positionMap.put(70, new Position(7*boardHeight / 15,10*boardWidth / 15));
		positionMap.put(71, new Position(7*boardHeight / 15,9*boardWidth / 15));
		positionMap.put(72, new Position(boardWidth / 15,boardHeight / 15));
		positionMap.put(73, new Position(4*boardWidth / 15,boardHeight / 15));
		positionMap.put(74, new Position(boardWidth / 15,4*boardHeight / 15));
		positionMap.put(75, new Position(4*boardWidth / 15,4*boardHeight / 15));
		positionMap.put(76, new Position(10*boardWidth / 15,boardHeight / 15));
		positionMap.put(77, new Position(13*boardWidth / 15,boardHeight / 15));
		positionMap.put(78, new Position(10*boardWidth / 15,4*boardHeight / 15));
		positionMap.put(79, new Position(13*boardWidth / 15,4*boardHeight / 15));
		positionMap.put(80, new Position(10*boardWidth / 15,10*boardWidth / 15));
		positionMap.put(81, new Position(13*boardWidth / 15,10*boardWidth / 15));
		positionMap.put(82, new Position(10*boardWidth / 15,13*boardWidth / 15));
		positionMap.put(83, new Position(13*boardWidth / 15,13*boardWidth / 15));
		positionMap.put(84, new Position(boardWidth / 15,10*boardHeight / 15));
		positionMap.put(85, new Position(4*boardWidth / 15,10*boardHeight / 15));
		positionMap.put(86, new Position(boardWidth / 15,13*boardHeight / 15));
		positionMap.put(87, new Position(4*boardWidth / 15,13*boardHeight / 15));
	}

	
}
