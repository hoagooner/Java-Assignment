package fa.training.services;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import fa.training.entities.Customer;

import static fa.training.main.Test.*;

public class IOService {
	public static void write() throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("customers.txt"));
			out.writeObject(customers);
		} catch (IOException e) {
			System.err.println("Error: writting file");
			e.printStackTrace();
		} finally {
			if (out != null) out.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void read() throws ClassNotFoundException, IOException {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("customers.txt"));
			customers =  (List<Customer>) in.readObject();
		} catch (IOException e) {
			System.err.println("Error: reading file");
		} finally {
			if (in != null) in.close();
		}
	}
}
