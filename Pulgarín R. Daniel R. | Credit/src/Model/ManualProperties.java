package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import Controller.Extensions;

public class ManualProperties {

	private Properties prop = new Properties();
	private String fileProp = Extensions.oneDriveFolder + "file" + ".properties";
	
	public void setProperties() {
		
		try {
			
			prop.setProperty("FILE NAME", Extensions.oneDriveFolder + "song"  + ".txt");
			prop.setProperty("PROP FILE", Extensions.oneDriveFolder + "song" + ".properties");
			prop.setProperty("CODE NAME", "Properties" + ".Java"); 
			prop.store(new FileOutputStream(fileProp), null);
		}
		catch(IOException ex) {
			
			ex.printStackTrace();
		}
	}
	
	 

	public String getProperties() {
		
		String dataRead = "";
		
		try {
			// load a properties file for reading
			prop.load(new FileInputStream(fileProp));
	
			// get the properties and print
			prop.list(System.out);
	
			//Reading each property value System.out.println(prop.getProperty("nombreArchivo")); System.out.println(prop.getProperty("archivoProp")); System.out.println(prop.getProperty("nombreCodigo"));
			dataRead = (prop.getProperty("FILE NAME")) +  "\n"
						+ (prop.getProperty("PROP FILE")) + "\n"
						+ (prop.getProperty("CODE NAME")) + "\n"; 
		} 
		catch (IOException ex) { 
			
			ex.printStackTrace();
		}
		return dataRead;
	}
	
}
