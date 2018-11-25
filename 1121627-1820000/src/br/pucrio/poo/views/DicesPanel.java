package br.pucrio.poo.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.pucrio.poo.controllers.ColorController;
import br.pucrio.poo.controllers.DicesController;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.utils.IObserver;

public class DicesPanel extends JPanel implements IObserver{
	private JButton lançarButton;	
	private DicesImagesPanel imagesPanel;
	private ActionListener buttonListener;
	private JLabel jogarLabel;
	DicesController dicesController;
	ColorController colorController;
	
	public DicesPanel(DicesController dicesController) {
		this.imagesPanel = new DicesImagesPanel();		
		this.lançarButton = new JButton("Lancar Dado");
		this.jogarLabel = new JLabel("JOGAR");
		this.colorController = new ColorController();
		this.dicesController = dicesController; 
		dicesController.registerObserver(this);
		

		// panel do botao
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(jogarLabel,BorderLayout.NORTH);	
		buttonPanel.add(lançarButton,BorderLayout.SOUTH);

		this.setLayout(null);
		this.add(buttonPanel);
		this.add(imagesPanel);
		Insets insets = getInsets();
		Dimension size = buttonPanel.getPreferredSize();
		buttonPanel.setBounds(insets.left, 100 + insets.top, size.width, size.height);	
		size = imagesPanel.getPreferredSize();
		imagesPanel.setBounds(insets.left, insets.top, size.width, size.height);
		//this.disablePanel();
	}
	
	public void repaint(Image diceImage, Color playerColor) {
		this.imagesPanel.setDiceImage(diceImage);
		this.imagesPanel.setPlayerColor(playerColor);
		this.imagesPanel.setBounds(0, 0, diceImage.getWidth(null), diceImage.getHeight(null));
		this.repaint();
	}

	public void enableTo(final Player player) {
		if (this.buttonListener != null) {
			this.lançarButton.removeActionListener(buttonListener);
		}

		this.buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				dicesController.roll(player);
			}
		};
		this.lançarButton.addActionListener(buttonListener);		
		this.enablePanel();
	}

	public void disablePanel() {
		this.lançarButton.setEnabled(false);
	}

	private void enablePanel() {
		this.lançarButton.setEnabled(true);
	}

	@Override
	public void updateView(Object o) {
		Player player = (Player)o;
		enableTo(player);		
		Image image = dicesController.getDiceImage(player);	
		Color playerColor = colorController.getColorFromPlayerColor(player.getColor());
		repaint(image,playerColor);
	}

}
