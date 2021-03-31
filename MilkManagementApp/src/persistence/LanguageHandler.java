package persistence;

import java.io.IOException;
import java.util.Properties;

import utils.Utilities;

public class LanguageHandler {
	public String fileName;
	public static String language = "undefined";
	public static Properties languageProperties;
	
	public LanguageHandler(String fileName){
		this.fileName = fileName;
	}
	
	public void loadLanguage() throws IOException {		
		Properties handlerproperties = Utilities.generateProperties(fileName);
		language = handlerproperties.getProperty("Language");
		languageProperties = Utilities.generateProperties(language);
	}
	
	public void saveLanguage() throws IOException {
		Properties handlerproperties = Utilities.generateProperties(fileName);
		handlerproperties.setProperty("Language", language);
		Utilities.saveProperties(handlerproperties, fileName);
	}
}
