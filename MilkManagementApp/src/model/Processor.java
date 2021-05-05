package model;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.IdNotFoundException;

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

	public ArrayList<ProductionEntry> getEntryList() {
		return entryList;
	}

	public void deleteEntry(int position) {
		entryList.remove(position);
	}

	public ArrayList<Object[]> generateFullList() {
		ArrayList<Object[]> fullList = new ArrayList<Object[]>();
		for (ProductionEntry entry : entryList) {
			fullList.add(entry.toObjectVector());
		}
		return fullList;
	}
	
	public ArrayList<String> generateOutputList() {
		ArrayList<String> fullList = new ArrayList<String>();
		for (ProductionEntry entry : entryList) {
			fullList.add(entry.toString());
		}
		return fullList;
	}

	public static ProductionEntry createProductionEntry(short ID, int year, String town, FarmingType farmingType,
			int dailyLitersPerCow, int numberOfCows, int dailyLiters) {

		ProductionEntry productionEntryAux = new ProductionEntry(ID, year, town, farmingType, dailyLitersPerCow,
				numberOfCows, dailyLiters);
		return productionEntryAux;
	}

	public short getGenerateID() {
		return (short) (getEntryList().size() + 1);
	}

	public int searchPositionNumber(int ID) throws IdNotFoundException {
		for (int i = 0; i < entryList.size(); i++) {
			ProductionEntry entry = entryList.get(i);
			if (entry.getID() == ID) {
				return i;
			}

		}
		throw new IdNotFoundException();
	}

	public ArrayList<Object[]> toMatrixVector() {
		ArrayList<Object[]> datasMatrix = new ArrayList<Object[]>();
		for (ProductionEntry production : entryList) {
			datasMatrix.add(production.toObjectVector());
		}
		return datasMatrix;
	}

	public ProductionEntry searchProductionEntryByID(int ID) throws IdNotFoundException {
		for (int i = 0; i < entryList.size(); i++) {
			ProductionEntry entry = entryList.get(i);
			if (entry.getID() == ID) {
				return entry;
			}
		}
		throw new IdNotFoundException();
	}

	public HashMap<String, Integer> generateReport1(int year) {
		// Grado de producción en relación al tipo de explotación(Lechería tradicional y
		// Lechería especializada). En general para todos los municipios
		HashMap<String, Integer> productionPerTown = new HashMap<String, Integer>();
		for (ProductionEntry entry : entryList) {
			int totalProduction1 = 0;
			int totalProduction2 = 0;
			int totalProduction3 = 0;
			switch (entry.getFarmingType().getType()) {
			case "LECHERIA TRADICIONAL":
				totalProduction1 += entry.getDailyLiters();
				productionPerTown.put(entry.getFarmingType().getType(), totalProduction1);
				break;
			case "LECHERIA ESPECIALIZADA":
				totalProduction2 += entry.getDailyLiters();
				productionPerTown.put(entry.getFarmingType().getType(), totalProduction2);
				break;
			case "DOBLE PROPOSITO":
				totalProduction3 += entry.getDailyLiters();
				productionPerTown.put(entry.getFarmingType().getType(), totalProduction3);
				break;
			}
		}
		return productionPerTown;
	}

}
