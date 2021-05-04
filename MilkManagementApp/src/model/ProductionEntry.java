package model;

public class ProductionEntry {
	private int year;
	private String town;
	private FarmingType farmingType;
	private int dailyLitersPerCow;
	private int numberOfCows;
	private int dailyLiters;
	private short ID;
	
	public ProductionEntry(short id, int year, String town, FarmingType farmingType, int dailyLitersPerCow, int numberOfCows,
			int dailyLiters) {
		this.ID = id;
		this.year = year;
		this.town = town;
		this.farmingType = farmingType;
		this.dailyLitersPerCow = dailyLitersPerCow;
		this.numberOfCows = numberOfCows;
		this.dailyLiters = dailyLiters;
	}

	public ProductionEntry(int year, String town, FarmingType farmingType) {
		this.year = year;
		this.town = town;
		this.farmingType = farmingType;
	}
	
	 public short getID() {
		return ID;
	}

	public int getYear() {
		return year;
	}

	public String getTown() {
		return town;
	}

	public FarmingType getFarmingType() {
		return farmingType;
	}

	public int getDailyLitersPerCow() {
		return dailyLitersPerCow;
	}

	public int getNumberOfCows() {
		return numberOfCows;
	}

	public int getDailyLiters() {
		return dailyLiters;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setFarmingType(FarmingType farmingType) {
		this.farmingType = farmingType;
	}

	public void setDailyLitersPerCow(int dailyLitersPerCow) {
		this.dailyLitersPerCow = dailyLitersPerCow;
	}

	public void setNumberOfCows(int numberOfCows) {
		this.numberOfCows = numberOfCows;
	}

	public void setDailyLiters(int dailyLiters) {
		this.dailyLiters = dailyLiters;
	}

	public Object[] toObjectVector() {
		return new Object[] {ID, year, town, farmingType.getType(), dailyLitersPerCow, numberOfCows, dailyLiters};
	}
}
