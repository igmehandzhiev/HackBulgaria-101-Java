package wordCountCommand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("/home/georgi/tmp/wordCountTest.txt");
		
		WordCountResult result = null;
		
		try {
			result = WordCountUtility.wordCount(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.toString());
		
		
		File file = new File("/home/georgi/tmp/wordCountTest.txt");
		try {
			result = WordCountUtility.wordCount(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.toString());
	}

}
