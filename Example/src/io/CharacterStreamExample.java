package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamExample {
	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader("input.txt");
			fw = new FileWriter("output.txt");

			int c = 0;
			while ((c = fr.read()) != -1) {
				fw.write(c);
			}
		} finally {
			if (fr != null) {
				fr.close();
			}
			if (fw != null) {
				fw.close();
			}
		}
	}
}
