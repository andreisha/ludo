package br.pucrio.poo.views.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import br.pucrio.poo.controllers.SaveGameController;
import br.pucrio.poo.models.utils.Serializer;

public class SaveGameButton extends JButton {
	private ActionListener listener;
	private SaveGameController saveGameController;

	public SaveGameButton(Serializer serializer) {
		super("Salvar");
		saveGameController = SaveGameController.getInstance(serializer);
		enable();
	}

	public void enable() {
		if (this.listener != null) {
			removeActionListener(listener);
		}

		this.listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Choose a directory to save your file: ");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					//if (jfc.getSelectedFile().isDirectory()) {
						File selectedFile = jfc.getSelectedFile();
						
						//if(Files.isWritable(selectedFile.toPath())){							
							saveGameController.saveGame(selectedFile.toPath());
							} else {
						  // no write access
						//}
					//}
				}
				
				
			}
		};
		addActionListener(listener);
	}
}
