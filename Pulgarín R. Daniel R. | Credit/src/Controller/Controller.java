package Controller;

import Model.ReadWriteFile;
import Model.World;
import View.Interface;

public class Controller {

	private World world; // This is the Model(world)
	private Interface view; // This is the interface
	private ReadWriteFile file;
	private String option, option2;

	
	public Controller() {
		
		// Constructors
		world = new World();
		view = new Interface();
				
		// Extra Data
		double effectiveRate;
		double annuityValue;
		double feeValue;
		
			
		System.out.println("Option 1");
			
		Extensions.creditTimeLapse = Integer.parseInt(view.askData("Time Lapse ex 48"));
		Extensions.creditInvestment = Double.parseDouble(view.askData("Investment ex 28070000"));
		Extensions.creditInterest = Double.parseDouble(view.askData("Interest ex 0.2343"));
			
		effectiveRate = Double.parseDouble(world.calculateEffectiveRate(Extensions.creditInterest));
		annuityValue = Double.parseDouble(world.annuityValue(effectiveRate, Extensions.creditTimeLapse));
		feeValue = Double.parseDouble(world.feeValue(Extensions.creditInvestment, annuityValue));
			
		world.calculateConstantFee(Extensions.creditTimeLapse, Extensions.creditInvestment, annuityValue, effectiveRate);
		
		// Functions
		option = view.askData(world.showDataToEvaluateSummary() + "\n"
								+ "-----------------------------------" + "\n"
								+ "Choose an option" + "\n"
								+ "-----------------------------------" + "\n"
								+ "1.)" + "Show all data" + "\n"
								+ "2.)" + "Show data per month" + "\n"
								);

		switch(option) {
		
		case "1": 
			view.writeData(Extensions.allCreditData);
			break;
		
		case "2":
			option2 = view.askData("Write the month fee number" + "\n"
					+ "Max" + Extensions.balanceDataArray.size() );
			
			view.writeData(world.showDataPerMonth(Integer.parseInt(option2) - 1));
			break;
			
		case "3":
			file.writeFile(Extensions.allCreditData);
			break;
		}
	}
}
