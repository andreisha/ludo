package br.pucrio.poo.views;
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
import br.pucrio.poo.utils.IEnableToObserver;
import br.pucrio.poo.utils.IResultObserver;

public class DicesPanel extends JPanel implements IResultObserver, IEnableToObserver{
	private JButton rollButton;	
	private JButton rollButton1;	
	private JButton rollButton2;	
	private JButton rollButton3;	
	private JButton rollButton4;	
	private JButton rollButton5;	
	private JButton rollButton6;	

	private DicesImagesPanel imagesPanel;
	private ActionListener buttonListener;
	private ActionListener buttonListener1;
	private ActionListener buttonListener2;
	private ActionListener buttonListener3;
	private ActionListener buttonListener4;
	private ActionListener buttonListener5;
	private ActionListener buttonListener6;

	private JLabel jogarLabel;
	private DicesController dicesController;
	private ColorController colorController;
	private PlayerWalkController playerWalkController;

	
	public DicesPanel(DicesController dicesController, PlayerWalkController playerWalkController) {
		this.imagesPanel = new DicesImagesPanel();		
		this.rollButton = new JButton("Lancar Dado");
		this.rollButton1 = new JButton("Lancar 1");
		this.rollButton2 = new JButton("Lancar 2");
		this.rollButton3 = new JButton("Lancar 3");
		this.rollButton4= new JButton("Lancar 4");
		this.rollButton5 = new JButton("Lancar 5");
		this.rollButton6 = new JButton("Lancar 6");

		this.jogarLabel = new JLabel("JOGAR");
		this.colorController = new ColorController();
		this.dicesController = dicesController; 
		this.playerWalkController = playerWalkController;
		dicesController.registerObserver(this);
		dicesController.registerEnableToObserver(this);

		// panel do botao
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(jogarLabel);	
		buttonPanel.add(rollButton);
		buttonPanel.add(rollButton1);
		buttonPanel.add(rollButton2);
		buttonPanel.add(rollButton3);
		buttonPanel.add(rollButton4);
		buttonPanel.add(rollButton5);
		buttonPanel.add(rollButton6);

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
	
	public void repaint(Image diceImage) {
		this.imagesPanel.setDiceImage(diceImage);
		if (diceImage != null) {
			
			this.imagesPanel.setBounds(0, 0, diceImage.getWidth(null), diceImage.getHeight(null));
		}
		this.repaint();
	}

	public void enableTo(final Player player) {
		if (this.buttonListener != null) {
			this.rollButton.removeActionListener(buttonListener);
		}
		if (this.buttonListener1 != null) {
			this.rollButton1.removeActionListener(buttonListener1);
		}		
		if (this.buttonListener2 != null) {
			this.rollButton2.removeActionListener(buttonListener2);
		}
		if (this.buttonListener3 != null) {
			this.rollButton3.removeActionListener(buttonListener3);
		}
		if (this.buttonListener4 != null) {
			this.rollButton4.removeActionListener(buttonListener4);
		}
		if (this.buttonListener5 != null) {
			this.rollButton5.removeActionListener(buttonListener5);
		}
		if (this.buttonListener6 != null) {
			this.rollButton6.removeActionListener(buttonListener6);
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
		
		this.rollButton.addActionListener(buttonListener);	
		this.rollButton1.addActionListener(buttonListener1);		
		this.rollButton2.addActionListener(buttonListener2);		
		this.rollButton3.addActionListener(buttonListener3);		
		this.rollButton4.addActionListener(buttonListener4);		
		this.rollButton5.addActionListener(buttonListener5);		
		this.rollButton6.addActionListener(buttonListener6);		

		this.enablePanel();
	}

	public void disablePanel() {
		this.rollButton.setEnabled(false);
		this.rollButton1.setEnabled(false);		
		this.rollButton2.setEnabled(false);		
		this.rollButton3.setEnabled(false);		
		this.rollButton4.setEnabled(false);		
		this.rollButton5.setEnabled(false);		
		this.rollButton6.setEnabled(false);
	}

	private void enablePanel() {
		this.rollButton.setEnabled(true);	
		this.rollButton1.setEnabled(true);		
		this.rollButton2.setEnabled(true);		
		this.rollButton3.setEnabled(true);		
		this.rollButton4.setEnabled(true);		
		this.rollButton5.setEnabled(true);		
		this.rollButton6.setEnabled(true);
	}

	@Override
	public void updateView(Object o) {
		this.disablePanel();
		Player player = (Player)o;	
	   Image image = dicesController.getDiceImage(player);	
	   repaint(image);
	}

	@Override
	public void EnableTo(Object obj) {
		Image image = null;
		Player player = (Player)obj;
		Color playerColor = colorController.getColorFromPlayerColor(player.getColor());
		this.imagesPanel.setPlayerColor(playerColor);
		repaint(image);
		
    	if (playerWalkController.isPlayerTurn(player.getColor())) 
			enableTo(player);		
	}

}
