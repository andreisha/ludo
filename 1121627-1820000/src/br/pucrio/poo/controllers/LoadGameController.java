package br.pucrio.poo.controllers;

import java.io.IOException;
import java.nio.file.Path;

import br.pucrio.poo.models.utils.Serializer;

public class LoadGameController {
	
	private static LoadGameController instance;
	private Serializer serializer;

	private LoadGameController(Serializer serializer) {
		this.serializer = serializer;
	}
	
	public static LoadGameController getInstance(Serializer serializer){
		if (instance == null) {			 
	    	instance = new LoadGameController(serializer);
		}
		return instance;
	}

	public void loadGame(Path path) {
		try {
			serializer.deserialize(path.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
