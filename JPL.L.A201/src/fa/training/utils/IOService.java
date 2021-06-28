package fa.training.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import fa.training.entities.Airport;

public class IOService {
	public static <T> void write(T t, String fileName) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(t);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) out.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static  <T> T read(T t, String fileName) throws ClassNotFoundException, IOException {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileName));
			t = (T) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) in.close();
		}
		return t;
	}
}
