package br.pucrio.poo.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.pucrio.poo.controllers.ColorController;
import br.pucrio.poo.controllers.DicesController;
import br.pucrio.poo.controllers.PlayerWalkController;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.utils.IResultObserver;

public class DicesPanel extends JPanel implements IResultObserver{
	private JButton lançarButton;	
	private JButton lançarButton1;	
	private JButton lançarButton2;	
	private JButton lançarButton3;	
	private JButton lançarButton4;	
	private JButton lançarButton5;	
	private JButton lançarButton6;	
	private DicesImagesPanel imagesPanel;
	private ActionListener buttonListener;
	private ActionListener buttonListener1;
	private ActionListener buttonListener2;
	private ActionListener buttonListener3;
	private ActionListener buttonListener4;
	private ActionListener buttonListener5;
	private ActionListener buttonListener6;

	private JLabel jogarLabel;
	DicesController dicesController;
	ColorController colorController;
	PlayerWalkController playerController;
	
	public DicesPanel(DicesController dicesController) {
		this.imagesPanel = new DicesImagesPanel();		
		this.lançarButton = new JButton("Lancar Dado");
		this.lançarButton1 = new JButton("Lancar 1");
		this.lançarButton2 = new JButton("Lancar 2");
		this.lançarButton3 = new JButton("Lancar 3");
		this.lançarButton4= new JButton("Lancar 4");
		this.lançarButton5 = new JButton("Lancar 5");
		this.lançarButton6 = new JButton("Lancar 6");

		this.jogarLabel = new JLabel("JOGAR");
		this.colorController = new ColorController();
		this.dicesController = dicesController; 
		dicesController.registerObserver(this);
		

		// panel do botao
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(jogarLabel);	
		buttonPanel.add(lançarButton);
		buttonPanel.add(lançarButton1);
		buttonPanel.add(lançarButton2);
		buttonPanel.add(lançarButton3);
		buttonPanel.add(lançarButton4);
		buttonPanel.add(lançarButton5);
		buttonPanel.add(lançarButton6);

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
		this.imagesPanel.setPlayerColor(playerColor);
		if (diceImage != null) {
			this.imagesPanel.setDiceImage(diceImage);
			this.imagesPanel.setBounds(0, 0, diceImage.getWidth(null), diceImage.getHeight(null));
		}
		this.repaint();
	}

	public void enableTo(final Player player) {
		if (this.buttonListener != null) {
			this.lançarButton.removeActionListener(buttonListener);
		}
		if (this.buttonListener1 != null) {
			this.lançarButton1.removeActionListener(buttonListener1);
		}		
		if (this.buttonListener2 != null) {
			this.lançarButton2.removeActionListener(buttonListener2);
		}
		if (this.buttonListener3 != null) {
			this.lançarButton3.removeActionListener(buttonListener3);
		}
		if (this.buttonListener4 != null) {
			this.lançarButton4.removeActionListener(buttonListener4);
		}
		if (this.buttonListener5 != null) {
			this.lançarButton5.removeActionListener(buttonListener5);
		}
		if (this.buttonListener6 != null) {
			this.lançarButton6.removeActionListener(buttonListener6);
		}
		this.buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				try {
						dicesController.roll(player);
						//disablePanel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		this.buttonListener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				try {
						dicesController.roll(player, 1);
						//disablePanel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		this.buttonListener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				try {
						dicesController.roll(player, 2);
						//disablePanel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		this.buttonListener3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				try {
						dicesController.roll(player, 3);
						//disablePanel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		this.buttonListener4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				try {
						dicesController.roll(player, 4);
						//disablePanel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		this.buttonListener5 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				try {
						dicesController.roll(player, 5);
						//disablePanel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		this.buttonListener6 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				try {
						dicesController.roll(player, 6);
						//disablePanel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		this.lançarButton.addActionListener(buttonListener);	
		this.lançarButton1.addActionListener(buttonListener1);		
		this.lançarButton2.addActionListener(buttonListener2);		
		this.lançarButton3.addActionListener(buttonListener3);		
		this.lançarButton4.addActionListener(buttonListener4);		
		this.lançarButton5.addActionListener(buttonListener5);		
		this.lançarButton6.addActionListener(buttonListener6);		

		//this.enablePanel();
		//disablePanel();
		

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
    	//if (playerController.isPlayerTurn(player)) 
			enableTo(player);	
	   Image image = dicesController.getDiceImage(player);	
		Color playerColor = colorController.getColorFromPlayerColor(player.getColor());
		repaint(image,playerColor);
		enablePanel();
	}

}