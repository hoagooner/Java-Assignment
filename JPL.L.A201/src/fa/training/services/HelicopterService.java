package fa.training.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Airport;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopter;
import fa.training.utils.IOService;

public class HelicopterService {

	static List<Airport> airports = new ArrayList<>();
	static List<Helicopter> helicopters = new ArrayList<>();

	public static void display() {

		try {
			airports = IOService.read(airports, "airports.txt");
			helicopters = IOService.read(helicopters, "helicopters.txt");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		String result = "";
		System.out.println("List of Helicopter: ");
		for (Helicopter helicopter : helicopters) {
			result += helicopter.toString();
			for (Airport airport : airports) {
				for (Helicopter helicopterOfAirport : airport.getHelicopters()) {
					if (helicopter.getID().equals(helicopterOfAirport.getID())) {
						result += "Airport ID: " + airport.getID() + ", Airport Name: " + airport.getName();
					}
				}
			}
		}

		System.out.println(result);
	}

	public static Helicopter findById(List<Helicopter> helicopters, String helicopterId) {
		for (Helicopter helicopter : helicopters) {
			if (helicopter.getID().equals(helicopterId)) {
				return helicopter;
			}
		}
		return null;
	}

}
