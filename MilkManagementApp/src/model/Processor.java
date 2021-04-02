package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Processor {
	private ArrayList<ProductionEntry> entryList;
	
	public Processor() {
		entryList = new ArrayList<>();
	}
	
	public void addEntry(ProductionEntry entry) {
		entryList.add(entry);
	}
	
	public void modifyEntry() {
		
	}
	
	public void deleteEntry(ProductionEntry entry) {
		entryList.remove(entry);
	}
	
	public ArrayList<Object[]> generateFullList() {
		ArrayList<Object[]> fullList = new ArrayList<Object[]>();
		for (ProductionEntry entry : entryList) {
			fullList.add(entry.toObjectVector());
		}
		return fullList;
	}
	
	public HashMap<String, Integer> generateReport1(int year) {
		//Grado de producción en relación al tipo de explotación(Lechería tradicional y Lechería especializada). En general para todos los municipios
		HashMap<String, Integer> productionPerTown = new HashMap<String, Integer>();
		for (ProductionEntry entry : entryList) {
			int totalProduction1 = 0;
			int totalProduction2 = 0;
			int totalProduction3 = 0;
			switch (entry.getFarmingType().getType()) {
			case "LECHERIA TRADICIONAL":
				totalProduction1 +=  entry.getDailyLiters();
				productionPerTown.put(entry.getFarmingType().getType(), totalProduction1);
				break;
			case "LECHERIA ESPECIALIZADA":
				totalProduction2 +=  entry.getDailyLiters();
				productionPerTown.put(entry.getFarmingType().getType(), totalProduction2);
				break;
			case "DOBLE PROPOSITO":
				totalProduction3 +=  entry.getDailyLiters();
				productionPerTown.put(entry.getFarmingType().getType(), totalProduction3);
				break;
			}
		}
		return productionPerTown;
	}

}
