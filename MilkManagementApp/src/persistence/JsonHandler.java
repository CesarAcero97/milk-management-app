package persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import model.ProductionEntry;
import utils.Utilities;

public class JsonHandler {
	
	public ArrayList<ProductionEntry> readFile(String fileName) throws FileNotFoundException, IOException, JsonException {
		ArrayList<ProductionEntry> personList = new ArrayList<>();
		JsonObject jsonObject = (JsonObject) Jsoner.deserialize(new FileReader(fileName));
		JsonArray entryList = (JsonArray) jsonObject.get("Entries");
		for (Object object : entryList) {
			JsonObject entryObj = (JsonObject) object;
			int year = entryObj.getInteger(JsonKeysList.YEAR);
			String town = entryObj.getString(JsonKeysList.TOWN);
			String farmingType = entryObj.getString(JsonKeysList.FARMING_TYPE);
			int dailyLitersPerCow = entryObj.getInteger(JsonKeysList.PRODUCTION_PER_DAY);
			int numberOfCows = entryObj.getInteger(JsonKeysList.COWS);
			int dailyLiters = entryObj.getInteger(JsonKeysList.TOTAL);
			ProductionEntry employee = new ProductionEntry(year, town, Utilities.parseFarmingType(farmingType), dailyLitersPerCow, numberOfCows, dailyLiters);
			personList.add(employee);
		}
		return personList;
	}
	
	
	
}
