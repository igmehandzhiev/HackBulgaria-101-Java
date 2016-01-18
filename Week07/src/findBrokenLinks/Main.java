package findBrokenLinks;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		try {
			BrokenLinks.find(Paths.get("/home/georgi/tmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
