import java.io.File;
import java.io.FileReader;

public class Test {
	public static void main(String[] args) {
		File file = new File("D:/input.txt");
		try (FileReader reader = new FileReader(file)) {
//			char[] cs = new char[5];
//			int bytes = reader.read(cs);
			int x = 0;
			while ((x = reader.read()) != -1) {
//				for (int i = 0; i < bytes; i++) {
////					System.out.print(i);
//					System.out.println(cs[i]);
//				}
//				bytes = reader.read(cs);
				System.out.println(x);
//				System.out.println(bytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
