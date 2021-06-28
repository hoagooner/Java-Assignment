import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedStreamSample {
	public static void main(String[] args) throws IOException {

		BufferedReader br = null;
		PrintWriter pw = null;
		
		FileReader fr = new FileReader("D:/input.txt");
		FileWriter fw = new FileWriter("D:/output.txt");
		
		try {
			br = new BufferedReader(fr);
			pw = new PrintWriter(fw);

			int line = 0;
			while ((line = br.read()) != (int) '\n') {
				pw.print((char) line);
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
