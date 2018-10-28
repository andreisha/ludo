package br.pucrio.poo.views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class DicesPainter {

	public void paintDicesImages(Graphics2D graphics,int x, int y, Image dice1Image, Image dice2Image) {
		graphics.drawImage(dice1Image, 0, 0, x, y, null);
		//graphics.drawImage(dice1Image, 0, 0, x, y, null);
	}
}

