package br.pucrio.poo.models.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import br.pucrio.poo.models.domain.Game;
import br.pucrio.poo.models.domain.Player;
import br.pucrio.poo.utils.Register;

public class Serializer {
	private static Serializer instance;
	private Game game;
	private Register register;

	private Serializer(final Game game, final Register register) {
		this.game = game;
		this.register = register;
	}

	public static Serializer getInstance(final Game game, final Register register) {
		if (instance == null) {
			instance = new Serializer(game, register);
		}
		return instance;
	}

	public void Serialize(String path) throws IOException {
		java2Gson(path);
	}

	public void deserialize(String path) {
		gson2Java(path);
	}

	private void java2Gson(String path) {
		try {
			//FileOutputStream fileOutputStream = new FileOutputStream(path);
			//OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			Writer writer = new FileWriter(path);

			GsonBuilder gsonBilder = new GsonBuilder();
			gsonBilder.excludeFieldsWithoutExposeAnnotation();
			gsonBilder.setPrettyPrinting();
			Gson gson = gsonBilder.create();

			String json = gson.toJson(this.game);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void gson2Java(String path) {

		try {
			//FileInputStream fileInputStream = new FileInputStream(path);
			//InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			Reader reader = new FileReader(path);

			GsonBuilder gsonBilder = new GsonBuilder();
			gsonBilder.excludeFieldsWithoutExposeAnnotation();
			gsonBilder.setPrettyPrinting();
			Gson gson = gsonBilder.create();

			game = gson.fromJson(reader, Game.class);
			game.initializeBoardSpotsCalculations();
			register.registerObservers(game);
			Player currentPlayer = game.currentPlayer();
			currentPlayer.notifyMoveObservers();
			currentPlayer.notifyEnableToObservers();
			currentPlayer.notifyResultObservers();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}