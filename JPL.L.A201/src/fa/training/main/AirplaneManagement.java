package fa.training.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Airport;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopter;
import fa.training.services.AirportService;
import fa.training.services.FixedwingService;
import fa.training.services.HelicopterService;
import fa.training.utils.IOService;

public class AirplaneManagement {
	public static void main(String[] args) throws IOException {

		String checkContinue = "";
		Scanner scanner = new Scanner(System.in);

		List<Airport> airports = new ArrayList<>();
		List<Helicopter> helicopters = new ArrayList<>();
		List<Fixedwing> fixedwings = new ArrayList<>();

		try {
			airports = IOService.read(airports, "airports.txt");
			fixedwings = IOService.read(fixedwings, "fixedwings.txt");
			helicopters = IOService.read(helicopters, "helicopters.txt");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		do {
			System.out.println("Choose function: ");
			System.out.println("1. Add a new Airport");
			System.out.println("2. Add a new Fixedwing");
			System.out.println("3. Add a new Helicopter");
			System.out.println("4. Add a Fixed-wing to an Airport");
			System.out.println("5. Remove a Fixed-wing to an Airport");
			System.out.println("6. Add a Helicopter to an Airport");
			System.out.println("7. Remove a Helicopter to an Airport");
			System.out.println("8. Change plane type and min needed runway size of fixed wing airplane");
			System.out.println("9. Display list of all airport information, sorted by airport ID ");
			System.out.println("10. Display the status of one airport, selected by airport ID");
			System.out.println("11. Display list of all fixed wing airplanes with its parking airport ID and name");
			System.out.println("12. Display list of all helicopters with its parking airport ID and name");
			System.out.println("13. Exit");
			System.out.print("Enter the number: ");

			String number = scanner.nextLine();
			switch (number) {
			case "1":
				AirportService.addAirport(airports);
				IOService.write(airports, "airports.txt");
				break;
			case "2":
				Fixedwing fixedwing = new Fixedwing();
				fixedwing.input(fixedwings);
				fixedwings.add(fixedwing);
				IOService.write(fixedwings, "fixedwings.txt");
				break;
			case "3":
				Helicopter helicopter = new Helicopter();
				helicopter.input(helicopters);
				helicopters.add(helicopter);
				IOService.write(helicopters, "helicopters.txt");
				break;
			case "4":
				AirportService.addFixedwingToAirport(airports, fixedwings);
				IOService.write(airports, "airports.txt");
				break;
			case "5":
				AirportService.removeFixedwing(airports);
				IOService.write(airports, "airports.txt");
				break;
			case "6":
				AirportService.addHellicopterToAirport(airports, helicopters);
				IOService.write(airports, "airports.txt");
				break;
			case "7":
				AirportService.removeHelicopter(airports);
				IOService.write(airports, "airports.txt");
				break;
			case "8":
				FixedwingService.changePlaneTypeAndRunwaySizeOfFixedWing(fixedwings);
				break;
			case "9":
				AirportService.displayBySortedID(airports);
				IOService.write(airports, "airports.txt");
				break;
			case "10":
				AirportService.displayStatusAirport(airports);
				break;
			case "11":
				FixedwingService.display(fixedwings);
				break;
			case "12":
				HelicopterService.display();
				break;
			case "13":
				checkContinue = "n";
				break;
			}
			System.out.println("---------------");
		} while (!"n".equalsIgnoreCase(checkContinue));
		scanner.close();
	}
}
