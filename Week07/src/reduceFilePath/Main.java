package reduceFilePath;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("/home//radorado/code/./hackbulgaria/week0/../");
		Path newPath = FilePath.reduce(path);
		System.out.println(newPath.toString());
	}

}
