package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import model.*;
import persistence.HandlerLanguage;
	
public class Utilities {
	
	private static final String TEXT_TOTAL_LITERS_PER_DAY = "Total_Liters_Per_Day";
	private static final String TEXT_NUMBER_COWS_FOR_MILKING = "Number_Cows_For_Milking";
	private static final String TEXT_PRODUCTION_PER_COW = "Production_Per_Cow";
	private static final String TEXT_TYPE_OF_EXPLOITATION = "Type_Of_Exploitation";
	private static final String TEXT_NAME_MUNICIPALITY = "Name_Municipality";
	private static final String TEXT_YEAR_SELECTION = "Year_Selection";
	private static final String TEXT_IDENTIFIER = "Identifier";

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
	
	
	
	public static boolean verifyFields( String jtfNameMunicipality) {
		if ( jtfNameMunicipality.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String[] SplitLine(String verifyLine) {
		return verifyLine.split(",");
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
		return HandlerLanguage.languageProperties.getProperty(vector);
	}
	
	public static String[] changeLanguageHeaders() {
		String[] headers = new String[7];
		headers[0] = HandlerLanguage.languageProperties.getProperty(TEXT_IDENTIFIER);
		headers[1] = HandlerLanguage.languageProperties.getProperty(TEXT_YEAR_SELECTION);
		headers[2] = HandlerLanguage.languageProperties.getProperty(TEXT_NAME_MUNICIPALITY);
		headers[3] = HandlerLanguage.languageProperties.getProperty(TEXT_TYPE_OF_EXPLOITATION);
		headers[4] = HandlerLanguage.languageProperties.getProperty(TEXT_PRODUCTION_PER_COW);
		headers[5] = HandlerLanguage.languageProperties.getProperty(TEXT_NUMBER_COWS_FOR_MILKING);
		headers[6] = HandlerLanguage.languageProperties.getProperty(TEXT_TOTAL_LITERS_PER_DAY);
		return headers;
	}

}
