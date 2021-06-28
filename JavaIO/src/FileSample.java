import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSample {
	public static void main(String[] args) throws IOException {

		File f = new File("D:/abc.txt");
		System.out.println(f.mkdir());
//		System.out.println(f.mkdirs());
		
		

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("D:/input.txt");
			fos = new FileOutputStream("D:/output.txt");
			int i;
			while ((i = fis.read()) != -1) {
				System.out.println(i);
				fos.write(i);
			}
		} finally {
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
	}
}
