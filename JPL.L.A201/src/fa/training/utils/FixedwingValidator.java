package fa.training.utils;

import java.util.List;

import fa.training.entities.Airport;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopter;

public class FixedwingValidator {
	public static boolean isID(String ID, List<Fixedwing> fixedwings) {
		for (Fixedwing fixedwing : fixedwings) {
			if (fixedwing.ID.equals(ID)) {
				throw new RuntimeException("ID has been exits");
			}
		}
		if (ID.matches("[F][W][0-9]{5}"))
			return true;
		throw new RuntimeException("ID incorret. Ex: FW00001, try again: ");
	}

	public static boolean isPlaneType(String planeType) {
		if (planeType.matches("CAG|LGR|PRV"))
			return true;
		throw new RuntimeException("Plane type incorret (CAG, LGR or PRV)");
	}

	public static boolean isParked(Double minNeededRunwaySize, Double runwaySize) {
		if (minNeededRunwaySize <= runwaySize)
			return true;
		throw new RuntimeException("min runway size of fixed wing does not excess the airport runway size.");
	}
}
