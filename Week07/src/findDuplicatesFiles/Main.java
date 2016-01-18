package findDuplicatesFiles;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args){
		
		try {
			DuplicateFiles.find(Paths.get(args[0]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DuplicateFiles.printToConsole();
		

	}

}
