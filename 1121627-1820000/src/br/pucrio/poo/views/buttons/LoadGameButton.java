package br.pucrio.poo.views.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import br.pucrio.poo.controllers.LoadGameController;
import br.pucrio.poo.controllers.SaveGameController;
import br.pucrio.poo.models.utils.Serializer;

public class LoadGameButton extends JButton {
	private ActionListener listener;
	private LoadGameController loadGameController; 

	public LoadGameButton(Serializer serializer) {
		super("Carregar Jogo");
		loadGameController = LoadGameController.getInstance(serializer);
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
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

				int returnValue = jfc.showOpenDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (jfc.getSelectedFile().isFile()) {
						File selectedFile = jfc.getSelectedFile();
						
						if(Files.isReadable(selectedFile.toPath())){							
							loadGameController.loadGame(selectedFile.toPath());
							} else {
						  // no read access
						}
					}
				}				
			}
		};
		addActionListener(listener);
	}
}