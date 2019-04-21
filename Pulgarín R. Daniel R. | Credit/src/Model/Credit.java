package Model;

import Controller.Extensions;

public class Credit {

public String calculateEffectiveRate(double financialInterest) {
		
		String answer = "";
		double effectiveRate;
		
		effectiveRate = (Math.pow((1 + financialInterest),(0.08333333333))) - 1;		
		answer += effectiveRate * 100;
		
		return answer;
	}
	
	public String annuityValue(double effectiveRate, double timeLapse) {
		
		String answer = "";
		double annuityValue;
		double efRate = effectiveRate * 100;
		
		annuityValue = ((1 - (Math.pow((1 + effectiveRate/100), -timeLapse)))/effectiveRate)*100;
		System.out.println(annuityValue);
		
		answer += annuityValue;
		return answer;
	}
	
	public String feeValue(double investment, double annuityValue) {
		
		String answer = "";
		double feeVal;
		
		feeVal = investment / annuityValue;
		System.out.println(feeVal);

		answer += feeVal;
		return answer;
	}
	
	public String calculateConstantFee(double timeLapse, double investment, double annuityValue, double effectiveRate) {
		
		String answer = "";
		double fee = investment/annuityValue;
		double interest;
		double amortization;
		double feeInvestment = investment;
		String feeText = "FEE  0 = " + fee + "\n" ;

		for (int i = 1; i <= timeLapse; i++) {

			interest = feeInvestment * effectiveRate/100;
			amortization = fee - interest;
			feeInvestment = feeInvestment - amortization;	
			feeText += "FEE " + i + " = " + "[" + feeInvestment + "," + fee + "," + interest + "," + amortization + "]" + "\n";
			
		}
		
		System.out.println(Extensions.allCreditData + "HOLA");
		
		return answer;
	}
}
