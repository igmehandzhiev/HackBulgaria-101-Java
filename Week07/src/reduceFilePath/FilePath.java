package reduceFilePath;

import java.nio.file.Path;

public class FilePath {

	
	public static Path reduce(Path path) { 
		
		return path.normalize();
	}
}
