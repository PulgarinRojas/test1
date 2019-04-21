package View;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Interface {

	public Interface() {
		
	}
	
	public String askData(String message) {
		
		return (JOptionPane.showInputDialog(null, message, "Titulo del InputDialog", JOptionPane.INFORMATION_MESSAGE));
	}
	
	public void writeData(String data) {
		JOptionPane.showMessageDialog(null, data, "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alert(String data) {
		
	}

	public String[] askDataAsArray(String[] pregunta) {
		
		String[] answersArray= new String[98];
		int i = 0;	
		
			while(i < 98) {	
				
					String a = JOptionPane.showInputDialog(null,pregunta[i],"Titulo del InputDialog",JOptionPane.INFORMATION_MESSAGE);	
					
					if (!a.equalsIgnoreCase("") && !a.equalsIgnoreCase(" ")) {
						
						if (a.equalsIgnoreCase("1") || a.equalsIgnoreCase("0")) {
							answersArray[i] = a;
							i++;
						}
						else
							JOptionPane.showMessageDialog(null, "INVALID ACTION, WRITE '1' or '0' being 1 yes & 0 no", "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);						
					}		
					else
						JOptionPane.showMessageDialog(null, "INVALID ACTION, ANSWER CAN NOT BE EMPTY", "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
			}			
		
		
		return answersArray;
	}
	

	public void writeTable(String dato) {
		
		UIManager.put("OptionPane.minimumSize",new Dimension(100,150));
		JOptionPane.showMessageDialog(null, dato, "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}
}
