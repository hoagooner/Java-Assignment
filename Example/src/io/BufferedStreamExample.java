package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedStreamExample {
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			pw = new PrintWriter(new FileWriter("output.txt", true));

			String line = null;
			while((line = br.readLine()) != null) {
				pw.println(line);
			}
			
		} finally {
			if (br != null) {
				br.close();
			}
			if (pw != null) {
				pw.close();
			}
		}
	}
}
