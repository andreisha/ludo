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

public class Serializer {
	private static Serializer instance;
	private Game game;

	private Serializer(final Game game) {
		this.game = game;
	}

	public static Serializer getInstance(final Game game) {
		if (instance == null) {
			instance = new Serializer(game);
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

		try (Writer writer = new OutputStreamWriter(new FileOutputStream(path), "UTF-8")) {
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
			String json = gson.toJson(this.game);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void gson2Java(String path){
		
		try(Reader reader = new InputStreamReader(new FileInputStream(path), "UTF-8")){
            Gson gson = new GsonBuilder().create();
            game = gson.fromJson(reader, Game.class);
            game.initializeBoardSpotsCalculations();
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
