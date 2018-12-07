package br.pucrio.poo.controllers;

import java.io.IOException;
import java.nio.file.Path;

import br.pucrio.poo.models.utils.Serializer;

public class SaveGameController {
	
	private static SaveGameController instance;
	private Serializer serializer;

	public SaveGameController(Serializer serializer) {
		this.serializer = serializer;
	}
	
	public static SaveGameController getInstance(Serializer serializer){
		if (instance == null) {			 
	    	instance = new SaveGameController(serializer);
		}
		return instance;
	}

	public void saveGame(Path dir) {
		String filename = "ludo.json";	
		Path path = dir.resolve(filename);
		try {
			serializer.Serialize(path.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
