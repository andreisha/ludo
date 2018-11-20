package br.pucrio.poo.views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class DicesPainter {

	public void paintDicesImages(Graphics2D graphics,int x, int y, int width, int height, Image diceImage) {
		graphics.drawImage(diceImage, x, y, width, height, null);
	}
}

