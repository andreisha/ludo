package br.pucrio.poo.views.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.pucrio.poo.controllers.SaveGameController;

public class SaveGameButton extends JButton {
	private ActionListener listener;

	public SaveGameButton() {
		super("Salvar");
	}

	public void enable(final SaveGameController saveGameController) {
		if (this.listener != null) {
			removeActionListener(listener);
		}

		this.listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveGameController.saveGame();
			}
		};
		addActionListener(listener);

		this.setEnabled(true);
	}
}
