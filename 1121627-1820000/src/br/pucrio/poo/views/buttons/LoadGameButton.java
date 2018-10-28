package br.pucrio.poo.views.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.pucrio.poo.controllers.LoadGameController;

public class LoadGameButton extends JButton {
	private ActionListener listener;

	public LoadGameButton() {
		super("Carregar Jogo");
	}

	public void enable(final LoadGameController loadGameController) {
		if (this.listener != null) {
			removeActionListener(listener);
		}

		this.listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadGameController.loadGame();
			}
		};
		addActionListener(listener);

		this.setEnabled(true);
	}
}