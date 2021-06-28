import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {

	private static final String FILE_NAME = "D:/input.csv";
	private static final String W_FILE_NAME = "D:/output.csv";
	private static final String TAB = "\t";
	private static final String BREAK_LINE = "\n";

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		try (FileReader fr = new FileReader(FILE_NAME); BufferedReader br = new BufferedReader(fr)) {
			String line = "";
			String infor[] = null;
			Person person = null;
			while ((line = br.readLine()) != null) {
				infor = line.split(",");
				person = new Person(infor[0], Integer.parseInt(infor[1]), infor[2]);
				persons.add(person);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileWriter fw = new FileWriter(W_FILE_NAME); BufferedWriter bw = new BufferedWriter(fw)) {

			for (Person person : persons) {
				bw.append(person.getName());
				bw.append("\t");
				bw.append( String.valueOf(person.getAge()));
				bw.append("\t");
				bw.append(person.getAddress());
				bw.append(BREAK_LINE);
			}
			
			bw.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
