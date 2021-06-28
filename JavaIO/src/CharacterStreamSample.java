import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamSample {
	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		FileWriter fw = null;
		
		fr = new FileReader("D:/input.txt");
		fw = new FileWriter("D:/output.txt");
		
	
		int c = 0;
		while((c = fr.read()) != -1) {
			System.out.println(c);
			fw.write(c);
		}
	}
}
