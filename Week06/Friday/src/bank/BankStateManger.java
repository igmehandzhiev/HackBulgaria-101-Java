package bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BankStateManger {
	
	public static void saveBank(TheBank bankToSave, String pathToSave) throws FileNotFoundException, IOException {
		try(ObjectOutputStream out = 
				new ObjectOutputStream( new FileOutputStream (pathToSave))) {
			
			out.writeObject(bankToSave);			
		}
	}
	
	public static TheBank retrieveBank(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		TheBank readBank = null;
		try(ObjectInputStream out = new ObjectInputStream( new FileInputStream (path))) {
			readBank = (TheBank)out.readObject();
		
		}
		return readBank;
	}
}
