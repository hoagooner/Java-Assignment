package fa.training.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.services.CustomerService;
import fa.training.services.IOService;

public class Test {
	public static List<Customer> customers = new ArrayList<Customer>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		IOService.read();

		Scanner scanner = new Scanner(System.in);
		String isExit = "N";
		String choice = "";
		do {
			printFunctions();
			System.out.print("Enter choice (1 - 5): ");
			choice = scanner.nextLine();
			switch (choice) {
			case "1": {
				CustomerService.createCustomer();
				IOService.write();
				System.out.println();
				break;
			}
			case "2": {
				System.out.println("------LIST OF CUSTOMER------");
				CustomerService.display(customers);
				System.out.println();
				break;
			}
			case "3": {
				System.out.println("------SEARCH CUSTOMER (by phone)------");
				System.out.print("Enter phone number: ");
				System.out.println(CustomerService.search(scanner.nextLine()));
				System.out.println();
				break;
			}
			case "4": {
				System.out.println("------REMOVE CUSTOMER (by phone)------");
				System.out.print("Enter phone number: ");
				if (CustomerService.remove(scanner.nextLine())) {
					System.out.println("Remove successfully !");
					System.out.println();
					IOService.write();
				} else {
					System.out.println("Remove failure");
					System.out.println();
				}
				break;
			}
			case "5": {
				isExit = "Y";
				break;
			}
			default:
				System.out.println("invalid choice, please enter valid choice: (1 - 5)");
			}
//			if (!isExit.equalsIgnoreCase("Y")) {
//				System.out.print("Exit program (press Y)? : ");
//				isExit = scanner.nextLine();
//			}

//		} while (!isExit.equalsIgnoreCase("Y"));
		}while(!"5".equalsIgnoreCase(choice));
	}

	public static void printFunctions() {
		System.out.println("Choose function");
		System.out.println("1. Add a new customer");
		System.out.println("2. Show all customers");
		System.out.println("3. Search customer");
		System.out.println("4. Remove customer");
		System.out.println("5. Exit");
	}
}