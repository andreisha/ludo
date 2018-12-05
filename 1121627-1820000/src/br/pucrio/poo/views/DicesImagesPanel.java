package br.pucrio.poo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class DicesImagesPanel extends JPanel {
	private Image diceImage;
	private DicesPainter painter;
	private Color playerColor;
	
	public DicesImagesPanel( ) {	
		this.painter = new DicesPainter();
	}
	
	@Override
    protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
        Graphics2D graphics = (Graphics2D)g.create();
        graphics.setPaint(playerColor);
        Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth(), getHeight());     
        graphics.fill(rect);
        
        // Draw square
        graphics.drawRect(10, 10, getWidth() -20, getHeight()-20);

        // Draw image inside square
        graphics.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION, 
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        
        if(this.diceImage != null)
		{
			painter.paintDicesImages((Graphics2D) graphics, 10, 10, getWidth() -20, getHeight()-20, this.diceImage);
		}

        graphics.dispose();
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(100, 100);
    }
	
	public void repaint(Image dice1Image) {
		if(diceImage == null)
			return;
		this.setBounds(0, 0, diceImage.getWidth(null), diceImage.getHeight(null));
		this.repaint();
	}
	
	public Image getDiceImage() {
		return diceImage;
	}
	
	public void setDiceImage(Image diceImage) {
		this.diceImage = diceImage;
	}
	
	public void setPlayerColor(Color color) {
		this.playerColor = color;
	}
}