package textFileCompression;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		
		TextFileCompression tfc = new TextFileCompression();
		
		try {
			tfc.compress(Paths.get("/home/georgi/tmp/toCompress.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			tfc.decompress(Paths.get("/home/georgi/tmp/decompressed.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
