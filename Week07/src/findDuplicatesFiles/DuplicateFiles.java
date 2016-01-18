package findDuplicatesFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateFiles {
	
	private static Map<Long, List<Path>> filesMap = new HashMap<>();
	
	public static void find(Path folderPath) throws IOException {
		File[] files = new File(folderPath.toString()).listFiles();
		
		walkFiles(files);
	}
	
	
	private static void walkFiles(File[] files) throws IOException {
		
		for(File file: files) {
			
			if(Files.isSymbolicLink(file.toPath()))
			{
				Path symPath = Files.readSymbolicLink(file.toPath());
				File symFile = new File(symPath.toString());
				
				if(!symFile.exists()) {
					continue;
				}
				
			}
			
			if (Files.isDirectory(file.toPath()) && file.listFiles().length > 0) {
				walkFiles(file.listFiles());
			} else if(Files.isRegularFile(file.toPath()) && !isBackupFile(file.toPath())){
				
				byte[] fileByites = Files.readAllBytes(file.toPath());
				long hashCode = Arrays.hashCode(fileByites);
				
				if(filesMap.containsKey(hashCode)) {
					filesMap.get(hashCode).add(file.toPath());
				} else {
					List<Path> paths= new ArrayList<>();
					paths.add(file.toPath());
					filesMap.put(hashCode, paths);
				}
				
			}
		}
	}
	
	private static boolean isBackupFile(Path path) {
		String pathToStr = path.toString();
		int strLenght = pathToStr.length();
		
		if(pathToStr.charAt(strLenght - 1) == '~') {
			return true;
		}
		return false;
	}

	
	public static void printToConsole() {
		
		int countGroups = 0;
		int totalDuplicates = 0;
		long sizeToFreeUp = 0L;
		
		System.out.println();
		
	
		for(Map.Entry<Long, List<Path>> entry: filesMap.entrySet()) {
			
			if (entry.getValue().size() >= 2) {
				countGroups++;
				totalDuplicates += entry.getValue().size() - 1;
				sizeToFreeUp += (entry.getValue().size() - 1) * entry.getValue().get(0).toFile().length();
				
				
				System.out.println("Group " + (char)(64 + countGroups));
				for(Path path: entry.getValue()) {
					System.out.println(path);
				}
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println(countGroups + " group(s) of duplications found.");
		System.out.println("A total of " + totalDuplicates + " duplicate files can be deleted, freeing up " + 
				sizeToFreeUp + " bytes disk space.");
	}
	
	
}
