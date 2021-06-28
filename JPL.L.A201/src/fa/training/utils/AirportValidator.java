package fa.training.utils;

import java.util.List;

import fa.training.entities.Airport;

public class AirportValidator {
	
	public static boolean isID(String ID, List<Airport> airports) {
		for (Airport airport : airports) {
			if (airport.ID.equals(ID)) throw new RuntimeException("ID has been exits, Enter again: "); 
		}
		if (ID.matches("[A][P][0-9]{5}")) return true;
		throw new RuntimeException("ID incorret. Ex: AP00001");
	}
}
