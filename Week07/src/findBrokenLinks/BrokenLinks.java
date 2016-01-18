package findBrokenLinks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BrokenLinks {

	public static void find(Path path) throws IOException {
		File[] files = new File(path.toString()).listFiles();
		System.out.println("Broken links: ");
		walkFiles(files);
	}

	private static void walkFiles (File[] files) throws IOException {
		
		for(File file: files) {
			
			if(Files.isSymbolicLink(file.toPath()))
			{
				Path symPath = Files.readSymbolicLink(file.toPath());
				File symFile = new File(symPath.toString());
				
				if(!symFile.exists()) {
					System.out.println(file.toString() + " ---> " + symPath.toString());
				}
				
			} else if (Files.isDirectory(file.toPath()) && file.listFiles().length > 0) {
				walkFiles(file.listFiles());
			}
		}
	}
}