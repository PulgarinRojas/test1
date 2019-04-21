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

	
	public String[] readFile() {
		
		File f= new File("Questionary CHASIDE.txt");
		
	   String[] preguntas= new String[98];
			
		try {
			
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea=br.readLine();					
			int i = 0;
			
			while(linea!=null&&i<98) {					
				preguntas[i]=linea;
				linea=br.readLine();				
				i++;			
				
			}
			
			fr.close();
			
		} catch(IOException e) {
	
			System.out.println("Could not be read!!!");
		}
		
		System.out.println();
	
		return preguntas;
	}

}
