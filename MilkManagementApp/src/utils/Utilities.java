package utils;

import model.*;

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

}
