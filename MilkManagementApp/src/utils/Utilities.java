package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import model.*;
import persistence.LanguageHandler;

public class Utilities {

	public static final FarmingType parseFarmingType(String farmingType) {
		FarmingType type = null;
		switch (farmingType) {
		case "LECHERIA TRADICIONAL":
			type = FarmingType.TRADITIONAL;
			break;
		case "LECHERIA ESPECIALIZADA":
			type = FarmingType.SPECIALIZED;
			break;
		case "DOBLE PROPOSITO":
			type = FarmingType.DOUBLE_PURPOSE;
			break;
		}
		return type;
	}
	
	// METODOS DE PROPIEDADES PARA CAMBIO DE LENGUAJE
	public static Properties generateProperties(String pathFile) throws IOException {
		Properties properties = new Properties();
		InputStream input = new FileInputStream(pathFile);
		properties.load( input );
		return properties;
	}
	
	public static void saveProperties(Properties properties, String pathFile) throws IOException{
		FileOutputStream output = new FileOutputStream(pathFile);
		properties.store(output, null);
		output.close();
	}
	
	public static String generateProperty(String vector) {
		return LanguageHandler.languageProperties.getProperty(vector);
	}

}
