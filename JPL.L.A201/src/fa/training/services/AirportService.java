package fa.training.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Airport;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopter;
import fa.training.utils.FixedwingValidator;

public class AirportService {
	public static Airport searchAirport(String ID, List<Airport> airports) {
		for (Airport airport : airports) {
			if (airport.ID.equals(ID)) {
				System.out.println(airport);
				return airport;
			}
		}
		return null;
	}

	public static void displayBySortedID(List<Airport> airports) {
		System.out.println("List information of Airport");
		Collections.sort(airports, new Comparator<Airport>() {

			@Override
			public int compare(Airport o1, Airport o2) {
				return o1.getID().compareTo(o2.getID());
			}
		});
		airports.forEach(airport -> System.out.println(airport));
	}

	public static void displayFixedwing(List<Airport> airports) {
		System.out.println("List of fixedwing");
		airports.forEach(airport -> {
			airport.fixedwings.forEach(fixedwing -> System.out
					.println(fixedwing + " Airport ID = " + airport.ID + ", Airport Name = " + airport.name));
		});
	}

	public static void displayHelicopter(List<Airport> airports) {
		System.out.println("List of Helicopter");
		airports.forEach(airport -> {
			airport.helicopters.forEach(helicopter -> System.out
					.println(helicopter + " Airport ID = " + airport.ID + ", Airport Name = " + airport.name));
		});
	}

	public static void addAirport(List<Airport> airports) {
		System.out.println("Create airport");
		Airport airport = new Airport();
		airport.input(airports);
		airports.add(airport);
	}

	@SuppressWarnings("resource")
	public static void addFixedwingToAirport(List<Airport> airports, List<Fixedwing> fixedwings) {
		System.out.print("Enter the Airport ID to add fixedwing: ");
		Scanner sc = new Scanner(System.in);
		String airportId = sc.nextLine();
		Airport airport = searchAirport(airportId, airports);
		if (airport != null) {
			System.out.print("Enter the Fixedwing ID to add: ");
			String fixedId = sc.nextLine();
			Fixedwing fixedwing = FixedwingService.findById(fixedwings, fixedId);

			if (fixedwing != null) {
				if (!isExistFixedwing(airport, fixedwing)) {
					try {
						if (FixedwingValidator.isParked(fixedwing.getMinNeededRunwaySize(), airport.getRunwaySize())) {
							airport.getFixedwings().add(fixedwing);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("This Fixed wing participate to an airport");
				}
			} else {
				System.out.println("Not Found Fixedwing");
			}
		} else {
			System.out.println("Not found Airport");
		}
	}

	@SuppressWarnings("resource")
	public static void addHellicopterToAirport(List<Airport> airports, List<Helicopter> helicopters) {
		System.out.print("Enter the Airport ID to add helicopter: ");
		Scanner sc = new Scanner(System.in);
		String airportId = sc.nextLine();
		Airport airport = searchAirport(airportId, airports);
		if (airport != null) {
			System.out.print("Enter the helicopter ID to add: ");
			String helicopterId = sc.nextLine();
			Helicopter helicopter = HelicopterService.findById(helicopters, helicopterId);

			if (helicopter != null) {
				if (!isExistHelicopter(airport, helicopter)) {
					airport.getHelicopters().add(helicopter);
					System.out.println("Add successfully");
				}
			} else {
				System.out.println("Not found helicopter with ID: " + helicopterId);
			}
		} else {
			System.out.println("Not found Airport");
		}
	}

	private static boolean isExistFixedwing(Airport airport, Fixedwing fixedwing) {
		for (Fixedwing fixedwingOfAirport : airport.getFixedwings()) {
			if (fixedwingOfAirport.getID().equals(fixedwing.getID())) {
				return true;
			}
		}
		return false;
	}

	private static boolean isExistHelicopter(Airport airport, Helicopter helicopter) {
		for (Helicopter helicopterOfAirport : airport.getHelicopters()) {
			if (helicopterOfAirport.getID().equals(helicopter.getID())) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("resource")
	public static void removeFixedwing(List<Airport> airports) {
		displayFixedwing(airports);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Ariport  to delete Fixedwing: ");
		String airportId = sc.nextLine();
		boolean notFoundAirport = true;
		boolean notFoundFixed = true;

		for (int i = 0; i < airports.size(); i++) {
			if (airports.get(i).getID().equals(airportId)) {
				notFoundAirport = false;
				System.out.print("Enter the fixedwing ID to delete: ");
				String ID = sc.nextLine();
				for (int j = 0; j < airports.get(i).fixedwings.size(); j++) {
					if (airports.get(i).fixedwings.get(j).ID.equals(ID)) {
						notFoundFixed = false;
						airports.get(i).fixedwings.remove(j);
						System.out.println("Remove successfully");
						break;
					}
				}
				if (notFoundFixed)
					System.out.println("Not found ID = " + ID);
			}
		}
		if (notFoundAirport)
			System.out.println("Not found Airport ID = " + airportId);

	}

	@SuppressWarnings("resource")
	public static void removeHelicopter(List<Airport> airports) {
		displayHelicopter(airports);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Ariport  to delete Helicopter: ");
		String airportId = sc.nextLine();
		boolean notFoundAirport = true;
		boolean notFoundHelicopter = true;

		for (int i = 0; i < airports.size(); i++) {
			if (airports.get(i).getID().equals(airportId)) {
				notFoundAirport = false;
				System.out.print("Enter the fixedwing ID to delete: ");
				String ID = sc.nextLine();
				for (int j = 0; j < airports.get(i).helicopters.size(); j++) {
					if (airports.get(i).helicopters.get(j).ID.equals(ID)) {
						notFoundHelicopter = false;
						airports.get(i).helicopters.remove(j);
						System.out.println("Remove successfully");
						break;
					}
				}
				if (notFoundHelicopter)
					System.out.println("Not found Helicopter with ID:  " + ID);
			}
		}

		if (notFoundAirport)
			System.out.println("Not found ID = " + airportId);
	}

	@SuppressWarnings("resource")
	public static void displayStatusAirport(List<Airport> airports) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the airport ID: ");
		String ID = sc.nextLine();

//		if (!searchAirport(ID, airports))
//			System.out.println("Not found ID = " + ID);
	}

}
