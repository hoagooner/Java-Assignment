package fa.training.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Airport;
import fa.training.entities.Fixedwing;
import fa.training.utils.FixedwingValidator;
import fa.training.utils.IOService;

public class FixedwingService {

	static List<Airport> airports = new ArrayList<>();

	public static void display(List<Fixedwing> fixedwings) {

		try {
			airports = IOService.read(airports, "airports.txt");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		String result = "";
		System.out.println("List of fixedwing: ");
		for (Fixedwing fixedwing : fixedwings) {
			result = fixedwing.toString();
			for (Airport airport : airports) {
				for (Fixedwing fixedwingOfAirport : airport.getFixedwings()) {
					if (fixedwing.getID().equals(fixedwingOfAirport.getID())) {
						result += " Airport ID: " + airport.getID() + ", Airport Name: " + airport.getName();
					}
				}
			}
			System.out.println(result);
		}
	}

	@SuppressWarnings("resource")
	public static void changePlaneTypeAndRunwaySizeOfFixedWing(List<Fixedwing> fixedwings) throws IOException {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter fixedwing ID: ");
		String fixedId = sc.nextLine();

		for (Fixedwing fixedwing : fixedwings) {
			if (fixedId.equals(fixedwing.getID())) {
				fixedwing.planeType = null;
				fixedwing.minNeededRunwaySize = null;
				while (true) {
					try {
						if (fixedwing.planeType == null) {
							System.out.print("Enter plane type: ");
							String planeType = sc.nextLine();
							fixedwing.planeType = FixedwingValidator.isPlaneType(planeType) ? planeType : null;
						}
						if (fixedwing.minNeededRunwaySize == null) {
							System.out.print("Enter min needed runway size: ");
							Double minNeededRunwaySize = Double.valueOf(sc.nextLine());
							fixedwing.minNeededRunwaySize = minNeededRunwaySize;
						}

						break;
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}
				System.out.println("update successfully");
				IOService.write(fixedwings, "fixedwings.txt");
				return;
			}
		}
		System.out.println("Not Found Fixedwing with ID: " + fixedId);
	}

	public static Fixedwing findById(List<Fixedwing> fixedwings, String fixedId) {
		for (Fixedwing fixedwing : fixedwings) {
			if (fixedwing.getID().equals(fixedId)) {
				return fixedwing;
			}
		}
		return null;
	}

}
