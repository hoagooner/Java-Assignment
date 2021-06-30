package io;

import java.io.File;
import java.io.IOException;

public class FileExample {
	public static void main(String[] args) throws IOException {
		File file = new File("text.txt");
		file.createNewFile();
		
		File dir = new File("D:/data/tmp/");
		dir.mkdirs();
		File file1 = new File("D:/data/tmp/text.txt");
		file1.createNewFile();
//		dir.mkdir();
	}
}
