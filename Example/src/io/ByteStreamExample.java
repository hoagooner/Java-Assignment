package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("input.txt");
			fos = new FileOutputStream("output.txt");

			int c = 0;
			while ((c = fis.read()) != -1) {
				System.out.print((char) c);
				fos.write(c);
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}

	}
}
