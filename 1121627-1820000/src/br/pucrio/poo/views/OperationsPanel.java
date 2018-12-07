package br.pucrio.poo.views;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import br.pucrio.poo.models.utils.Serializer;
import br.pucrio.poo.views.buttons.LoadGameButton;
import br.pucrio.poo.views.buttons.NewGameButton;
import br.pucrio.poo.views.buttons.SaveGameButton;

public class OperationsPanel extends JPanel {
	private NewGameButton newGameButton;
	private LoadGameButton loadGameButton;
	private SaveGameButton saveGameButton;

	public OperationsPanel(Serializer serializer) {
		Dimension size;
		this.newGameButton = new NewGameButton();
		this.loadGameButton = new LoadGameButton(serializer);
		this.saveGameButton = new SaveGameButton(serializer);

		// this.setLayout(null);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(newGameButton);
		this.add(loadGameButton);
		this.add(saveGameButton);

//		Insets in = this.getInsets();
//		size=newGameButton.getPreferredSize();
//		newGameButton.setBounds(25+in.left, 5+in.top,size.width,size.height);
//		size=loadGameButton.getPreferredSize();
//		loadGameButton.setBounds(55+in.left,40+in.top,size.width,size.height);
//		size=saveGameButton.getPreferredSize();
//		saveGameButton.setBounds(150+in.left,15+in.top,size.width+50,size.height+20);
	}

	public NewGameButton getNewGameButton() {
		return newGameButton;
	}

	public LoadGameButton getLoadGameButton() {
		return loadGameButton;
	}

	public SaveGameButton getSaveGameButton() {
		return saveGameButton;
	}
}
