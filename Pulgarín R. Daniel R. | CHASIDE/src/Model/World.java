package Model;

public class World {

	
	private String data;

	private ReadWriteFile file;
	private CHASIDE chaside;
	private Persistence persistence;
	
	public World() {
		
		file = new ReadWriteFile();
		chaside = new CHASIDE();
		persistence = new Persistence();
		
	}
	
	
	public void fillQuestionaryAnswers(String[] resp) {		
		chaside.setAnswers(resp);
		
	}
	
	
	public String[] readFile() {		
			return file.readFile();			
	}	
	
	
	public String affirmativeAnswers(String[] letraChaside) {
		
		String answer = "";
		int counter = 0;		
		
		for (int i = 0; i < chaside.getAnswers().length; i++) {
		
			if (chaside.getAnswers()[i].equals("1")) {
			
				String posicion= String.valueOf((i+1));
				int position=(i+1);
				
				if (position <= 9) {
				
					posicion = "0" + posicion;
				}
				
				for (int j = 0; j < letraChaside.length; j++) {
				
					if (posicion.equals(letraChaside[j])) {	counter++; }				
				}
			}			
		}		
		
		if (counter <= 9) { answer += "0" + String.valueOf(counter); }
		else { answer += counter; }
		
		return answer;
	}
	
	
	public String buildTableFromData() {
		
		int k = 0;
		
		String messageToShow = "<html>";
		String tab = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		messageToShow += "______________________| INTERESES |______________________" + "<br>";
		
		for (int j = 0; j < persistence.cI.length; j++) {	
			
			if (j >= 5) {
				
				messageToShow += persistence.cI[j] + tab +
									persistence.hI[j] + tab +
									persistence.aI[j] + tab +
									persistence.sI[j] + tab + 
									persistence.iI[j] + tab +
									persistence.dI[j] + tab + 
									persistence.eI[j];	
			}
			else {
				
				messageToShow += persistence.cI[j] + tab +
									persistence.hI[j] + tab +
									persistence.aI[j] + tab + 
									persistence.sI[j] + tab +
									persistence.iI[j] + tab +
									persistence.dI[j] + tab +
									persistence.eI[j] + tab + "<br>";
			}
			
			if (j==5) {
				messageToShow += tab + "_______________________| APTITUDES |_______________________" + "<br>";
			}
			
			if (j >= 6 && k<4) {
				
				messageToShow += tab + persistence.cA[k] +
									tab + persistence.hA[k] +
									tab + persistence.aA[k] +
									tab + persistence.sA[k] + 
									tab + persistence.iA[k] +
									tab + persistence.dA[k] +
									tab + persistence.eA[k] +
									tab + "<br>";
				k++;
			}		
								
	}
		messageToShow +=  "__________________________________________________________	|	___________________________________________________________" + "<br>" + 
				affirmativeAnswers(persistence.cI) + tab + affirmativeAnswers(persistence.hI) + tab + 
				affirmativeAnswers(persistence.aI) + tab + affirmativeAnswers(persistence.sI) + tab + 
				affirmativeAnswers(persistence.iI) + tab + affirmativeAnswers(persistence.dI) + tab + 
				affirmativeAnswers(persistence.eI) + tab + affirmativeAnswers(persistence.cA) + tab + 
				affirmativeAnswers(persistence.hA) + tab + affirmativeAnswers(persistence.aA) + tab + 
				affirmativeAnswers(persistence.sA) + tab + affirmativeAnswers(persistence.iA) + tab + 
				affirmativeAnswers(persistence.dA) + tab + affirmativeAnswers(persistence.eA) + "<br>" +
				"_C" + tab + "_H" + tab + "_A" + tab + "_S" + tab + "_I" + tab + "_D" + tab + "_E" + tab + "|" +
				"c" + tab + "_h" + tab + "_a" + tab + "_s" + tab + "_i" + tab + "_d" + tab + "_e" + tab +
	            "<br>" + "<br>" + 
	            tab + tab + "<br>" + "<br>" + "<br>" + tab + tab + tab + tab +
				"Guía:" + "<br>" + "<br>" + tab + tab + tab + tab +
				"C : " + "Administrativas y Contables" +"<br>" + tab + tab + tab + tab +
				"H : " + "Humanísticas y Sociales" +"<br>" + tab + tab + tab + tab +
	            "A : " + "Artísticas" + "<br>" + tab + tab + tab + tab +
	            "S : " + "Medicina y Cs. De la Salud"+ "<br>" + tab + tab + tab + tab +
	            "I : " + "Ingeniería y Computación"+ "<br>" + tab + tab + tab + tab +
	            "D : " + "Defensa y Seguridad"+ "<br>" + tab + tab + tab + tab +
	            "E : " + "Ciencias Exactas y Agrarias";
		
		messageToShow += "</html>";
		
		return messageToShow;
	}
}
