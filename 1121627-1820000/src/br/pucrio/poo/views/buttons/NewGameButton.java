package br.pucrio.poo.views.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.pucrio.poo.controllers.NewGameController;
import br.pucrio.poo.models.utils.Serializer;

public class NewGameButton extends JButton {
	private ActionListener listener;
	private NewGameController newGameController;
	private Serializer serializer;

	public NewGameButton(Serializer serializer) {
		super("Novo Jogo");
		this.serializer = serializer;
		this.newGameController = NewGameController.getInstance();
		enable();
	}

	public void enable() {
		if (this.listener != null) {
			removeActionListener(listener);
		}

		this.listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newGameController.startNewGame(serializer);
			}
		};
		addActionListener(listener);
	}
}
