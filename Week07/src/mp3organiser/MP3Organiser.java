package mp3organiser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractID3v2;

public class MP3Organiser {
	
	public static void fixNames(Path path) throws IOException, TagException {
		File[] files = new File(path.toString()).listFiles();
		traverseFilesToFixNames(files);
	}

	private static void traverseFilesToFixNames(File[] files) throws IOException, TagException {
		
		for(File file: files) {
			
			if (Files.isDirectory(file.toPath()) && file.listFiles().length > 0) {
				traverseFilesToFixNames(file.listFiles());
			} else if(isMP3(file)){
				
				MP3File mp3 = new MP3File(file);
				AbstractID3v2 id3v2 = mp3.getID3v2Tag();
				
				File newFile = new File(file.getParent() + "/"+ id3v2.getLeadArtist() + " - " + id3v2.getSongTitle() + ".mp3");
				
				if(newFile.exists()) {
					continue;
				}
				
				boolean success = file.renameTo(newFile);
				if(!success) {
					System.out.println("File not renamed!");
				}
				
			}
		}
		
	}

	private static boolean isMP3(File file) {
		String pathToStr = file.toString();
		int index = pathToStr.lastIndexOf('.');
		String extension = pathToStr.substring(index + 1, pathToStr.length());
		
		if(extension.equals("mp3")) {
			return true;
		}
		return false;
	}
	
	
	public static void organiseToFolders(Path source, Path destination) throws IOException, TagException {
		File[] files = new File(source.toString()).listFiles();
		traverseFilesToOrganiseFolders(files, destination);
	}
	
	private static void traverseFilesToOrganiseFolders(File[] files, Path destination) throws IOException, TagException {
		
		for(File file: files) {
			
			if (Files.isDirectory(file.toPath()) && file.listFiles().length > 0) {
				traverseFilesToOrganiseFolders(file.listFiles(), destination);
			} else if(isMP3(file)){
				
				MP3File mp3 = new MP3File(file);
				AbstractID3v2 id3v2 = mp3.getID3v2Tag();
				
				String artistName = id3v2.getLeadArtist();
				File nameFolder = null;
				if(artistName.length() == 0) {
					nameFolder = new File(destination.toString() + "/Unknown Artists/");
					
				} else {
					nameFolder = new File(destination.toString() + "/" + artistName);
				}
				
				String albumTitle = id3v2.getAlbumTitle();
				File albumFolder = null;
				if(albumTitle.length() == 0) {
					albumFolder = new File(nameFolder.toString() + "/Unknown Album/" );
					
				} else {
					String newAlbumFolder = nameFolder.toString() + "/" + albumTitle ;
					albumFolder = new File(newAlbumFolder);
					
					
				}
				
				if(nameFolder.exists()) {
					if(albumFolder.exists()) {
						Files.move(file.toPath(), albumFolder.toPath().resolve(file.getName()));
						
					} else {
						Files.createDirectories(albumFolder.toPath());
						Files.move(file.toPath(), albumFolder.toPath());
					}
					
				} else {
					Files.createDirectories(albumFolder.toPath());
					Files.move(file.toPath(), albumFolder.toPath().resolve(file.getName()));
				}
				
			}
				
		}
	}
}
