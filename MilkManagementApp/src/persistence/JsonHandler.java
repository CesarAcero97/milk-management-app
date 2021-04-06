package persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import model.ProductionEntry;
import utils.Utilities;

public class JsonHandler {
	
	public ArrayList<ProductionEntry> readFile(String fileName) throws FileNotFoundException, IOException, DeserializationException {
		ArrayList<ProductionEntry> personList = new ArrayList<>();
		JsonObject jsonObject = (JsonObject) Jsoner.deserialize(new FileReader(fileName));
		JsonArray entryList = (JsonArray) jsonObject.get("lista");
		int year, dailyLitersPerCow, numberOfCows, dailyLiters;
		String town, farmingType;
		
		for (int i = 0; i < entryList.size(); i++) {
			JsonObject entryObj = (JsonObject) entryList.get(i);
			try {
				if (entryObj.getInteger("produccion_por_vaca_litros_dia") == null && entryObj.getInteger("vacas_para_orde_o") == null && entryObj.getInteger("total_litros_d_a") == null) {
					year = entryObj.getInteger("a_o");
					town = entryObj.getString("municipio");
					farmingType = entryObj.getString("tipo_de_explotacion");
					dailyLitersPerCow = 0;
					numberOfCows = 0;
					dailyLiters = 0;
				} else {
					year = entryObj.getInteger("a_o");
					town = entryObj.getString("municipio");
					farmingType = entryObj.getString("tipo_de_explotacion");
					dailyLitersPerCow = entryObj.getInteger("produccion_por_vaca_litros_dia");
					numberOfCows = entryObj.getInteger("vacas_para_orde_o");
					dailyLiters = entryObj.getInteger("total_litros_d_a");
				}
				ProductionEntry employee = new ProductionEntry(year, town, Utilities.parseFarmingType(farmingType), dailyLitersPerCow, numberOfCows, dailyLiters);
				System.out.println(year + "\n" + town + "\n" + farmingType + "\n" + dailyLitersPerCow + "\n" + numberOfCows + "\n" +  dailyLiters + "\n");
				personList.add(employee);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

		}
		return personList;
	}
	
	public static void readFileFromUrl(String url) throws IOException, DeserializationException {
		String webService = "https://www.datos.gov.co/resource/3urw-7985.json";
//		String webService = "https://www.datos.gov.co/api/views/3urw-7985/rows.json?accessType=DOWNLOAD";
		BufferedReader rd = new BufferedReader(new InputStreamReader(getInputStream(false, webService)));
		System.out.println("OUTPUT IS -------------");
		
		JsonObject jsonObject = (JsonObject) Jsoner.deserialize(rd);
		JsonArray jsonArrayEntryList = (JsonArray) jsonObject.get("lista");
		
		for (int i = 0; i < jsonArrayEntryList.size(); i++) {
			JsonObject jsonFN = (JsonObject) jsonObject.get(i);
			System.out.println("Año: " + jsonFN.getInteger("a_o"));
		}
	}
	
	public static InputStream getInputStream(boolean isProxy, String filePath) {
		HttpURLConnection httpURLConnection;
		URL url = null;
		InputStream inputStream = null;
		try {
			url = new URL(filePath);
			if (!isProxy) {
				System.out.println("Sin proxy");
				httpURLConnection = (HttpURLConnection) url.openConnection();	
				inputStream = httpURLConnection.getInputStream();
			} else {
				System.out.println("Con proxy");
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("0.0.0.0", 8080));
				httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
				inputStream = httpURLConnection.getInputStream();
			}

		} catch (ConnectException connectException) {
			isProxy = true;
			return getInputStream(isProxy, filePath);
		} catch (UnknownHostException e) {
			isProxy = true;
			return getInputStream(isProxy, filePath);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}
	
	public static void main(String[] args) {
		try {
			new JsonHandler().readFile("resources/input/data.json");
		} catch (IOException | DeserializationException e) {
			e.printStackTrace();
		}
	}
	
}
