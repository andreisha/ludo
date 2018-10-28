package br.pucrio.poo.views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class DicesImagesPanel extends JPanel {
	private Image dice1Image;
	private Image dice2Image;
	private DicesPainter painter;
	
	public DicesImagesPanel( ) {	
		
	this.painter = new DicesPainter();
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		if(this.dice1Image != null && this.dice2Image != null)
		{
			painter.paintDicesImages((Graphics2D) graphics, this.getWidth(), this.getHeight(), this.dice1Image, this.dice2Image);
		}
	}
	
	public void repaint(Image dice1Image, Image dice2Image) {
		this.setBounds(0, 0, dice1Image.getWidth(null), 2*dice2Image.getHeight(null));
		this.repaint();
	}
	
	public Image getDice1Image() {
		return dice1Image;
	}
	public void setDice1Image(Image dice1Image) {
		this.dice1Image = dice1Image;
	}
	public Image getDice2Image() {
		return dice2Image;
	}
	public void setDice2Image(Image dice2Image) {
		this.dice2Image = dice2Image;
	}

}
