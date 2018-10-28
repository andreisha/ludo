package br.pucrio.poo.views.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.pucrio.poo.controllers.NewGameController;

public class NewGameButton extends JButton {
	private ActionListener listener;

	public NewGameButton() {
		super("Novo Jogo");
	}
	
	public void enable(final NewGameController newGameController) {
		if (this.listener != null) {
			removeActionListener(listener);
		}
		
		this.listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newGameController.startNewGame();
			}
		};
		addActionListener(listener);
		
		this.setEnabled(true);
	}
}
