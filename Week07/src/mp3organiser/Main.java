package mp3organiser;

import java.io.IOException;
import java.nio.file.Paths;

import org.farng.mp3.TagException;

public class Main {

	public static void main(String[] args) {
		try {
			MP3Organiser.organiseToFolders(Paths.get("/home/georgi/Music/"), Paths.get("/home/georgi/OrganisedMusic/"));
		} catch (IOException | TagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
