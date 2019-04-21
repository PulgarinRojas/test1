package View;

import javax.swing.JOptionPane;

public class Interface {

	public Interface() {
		
	}
	
	public String askData(String message) {
		
		return (JOptionPane.showInputDialog(null, message, "Titulo del InputDialog", JOptionPane.INFORMATION_MESSAGE));
	}
	
	public void writeData(String data) {
		JOptionPane.showMessageDialog(null, data, "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}
}
