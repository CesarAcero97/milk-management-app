package model;

import java.util.ArrayList;

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

}
