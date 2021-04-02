package persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
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
	
	public static String readFileFromUrl(String url) {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                return readAll(rd);
            } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
	
	private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1)
            sb.append((char) cp);
        String result = sb.toString();
        return result.replaceAll("\\\\n", "");
    }
	
}
