package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Controller.Extensions;

public class ReadWriteFile {

	private File f;
	private File secondF;
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private PrintWriter pw;
	private String line;

	
	public String readFile() {
		
		String dataRead = "";
		
		// Getting file to load
		f = new File(Extensions.oneDriveFolder + "song.txt");
		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			// Reading file
			line = br.readLine();
			
			while (line != null) {
				
				dataRead = dataRead + "\n" + line;
				line = br.readLine();			
			}
			
			fr.close();
		}
		catch (IOException e) {
			
			System.out.println("ERROR!!, Can not open the file!!!");
		}
		
		return dataRead;
	}
	
	public void writeFile(String textToWrite) {
		
		// Getting file to load
		secondF = new File(Extensions.oneDriveFolder + "Credit" + ".txt");
		
		try {
			
			fw = new FileWriter(secondF);
			pw = new PrintWriter(fw);
			
			pw.println(textToWrite);
			fw.close();
			
		}
		catch (IOException e) {					
				System.out.println("ERROR!!, Can not write the file!!!");
		}
	}
}
