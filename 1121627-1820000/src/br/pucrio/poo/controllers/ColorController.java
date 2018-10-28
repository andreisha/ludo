package br.pucrio.poo.controllers;

import java.awt.Color;
import java.util.HashMap;
import br.pucrio.poo.models.domain.PlayerColor;

public class ColorController {

	private HashMap<PlayerColor, Color> colorFromPlayerColorMap = new HashMap<PlayerColor, Color>();
	private HashMap<Color, PlayerColor> playerColorFromColorMap = new HashMap<Color, PlayerColor>();

	public ColorController() {
		InitializeMaps();
	}

	private void InitializeMaps() {
		/* Adding elements to colorFromPlayerColorMap */
		colorFromPlayerColorMap.put(PlayerColor.RED, Color.RED);
		colorFromPlayerColorMap.put(PlayerColor.GREEN, Color.GREEN);
		colorFromPlayerColorMap.put(PlayerColor.BLUE, Color.BLUE);
		colorFromPlayerColorMap.put(PlayerColor.YELLOW, Color.YELLOW);

		/* Adding elements to colorFromPlayerColorMap */
		playerColorFromColorMap.put(Color.RED, PlayerColor.RED);
		playerColorFromColorMap.put(Color.GREEN, PlayerColor.GREEN);
		playerColorFromColorMap.put(Color.BLUE, PlayerColor.BLUE);
		playerColorFromColorMap.put(Color.YELLOW, PlayerColor.YELLOW);
	}

	public Color getColorFromPlayerColor(PlayerColor playerColor) {
		return colorFromPlayerColorMap.get(playerColor);
	}

	public PlayerColor getPlayerColorFromColor(Color color) {
		return playerColorFromColorMap.get(color);
	}
}