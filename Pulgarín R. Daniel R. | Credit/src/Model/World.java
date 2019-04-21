package Model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import Controller.Extensions;

public class World {

	
	private String data;
	DecimalFormat df = new DecimalFormat("0.000000"); 	// Use a DecimalFormat object
	
	public World() {
		data = "";
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void processData() {
		this.data = this.data + "	loading...";
	}
	
	
	public String calculateEffectiveRate(double financialInterest) {
		
		String answer = "";
		double effectiveRate;
		
		effectiveRate = (Math.pow((1 + financialInterest),(0.08333333333))) - 1;		
		answer += effectiveRate * 100;
		
		Extensions.creditEffectiveRate = Double.parseDouble(answer);
		
		return answer;
	}
	
	public String annuityValue(double effectiveRate, double timeLapse) {
		
		String answer = "";
		double annuityValue;
		double efRate = effectiveRate * 100;
		
		annuityValue = ((1 - (Math.pow((1 + effectiveRate/100), -timeLapse)))/effectiveRate)*100;
		System.out.println(annuityValue);
		
		answer += annuityValue;
		Extensions.creditAnnuityValue = Double.parseDouble(answer);

		return answer;
	}
	
	public String feeValue(double investment, double annuityValue) {
		
		String answer = "";
		double feeVal;
		
		feeVal = investment / annuityValue;
		System.out.println(feeVal);

		answer += feeVal;
		Extensions.creditFeeValue = Double.parseDouble(answer);

		return answer;
	}
	
	public String calculateConstantFee(double timeLapse, double investment, double annuityValue, double effectiveRate) {
		
		String answer = "";
		double fee = investment/annuityValue;
		double interest;
		double amortization;
		double feeInvestment = investment;
		String feeFormatted = NumberFormat.getCurrencyInstance(new Locale("en", "US"))
		        .format(fee);
		String feeInvestmentFormatted, interestFormatted, amortizationFormatted;
		String feeText = "FEE  0 = " + fee + "\n" ;

		for (int i = 1; i <= timeLapse; i++) {

			interest = feeInvestment * effectiveRate/100;
			interestFormatted = NumberFormat.getCurrencyInstance(new Locale("en", "US"))
			        .format(interest);
			amortization = fee - interest;
			amortizationFormatted = NumberFormat.getCurrencyInstance(new Locale("en", "US"))
			        .format(amortization);
			feeInvestment = feeInvestment - amortization;
			feeInvestmentFormatted = NumberFormat.getCurrencyInstance(new Locale("en", "US"))
			        .format(feeInvestment);
			feeText += "FEE " + i + " = " + feeInvestmentFormatted + "	|	" + feeFormatted + "	|	" + interestFormatted + "	|	" + amortizationFormatted  + "\n";
			
			// Data to Array
			Extensions.balanceDataArray.add(feeInvestmentFormatted);
			Extensions.feeAmountDataArray.add(feeFormatted);
			Extensions.interestFormattedDataArray.add(interestFormatted);
			Extensions.amortizationFormattedDataArray.add(amortizationFormatted);
		}
		
		Extensions.allCreditData += feeText;

		return answer;
	}
	
	public String showDataPerMonth(int month) {
		
		String answer = "";
		
		answer += "DATA IN MONTH: " + (month + 1)
					+ "\n" + "----------------------------------"
					+ "\n" + "BALANCE: " + Extensions.balanceDataArray.get(month)
					+ "\n" + "FEE AMOUNT: " + Extensions.feeAmountDataArray.get(month)
					+ "\n" + "INTEREST: " + Extensions.interestFormattedDataArray.get(month)
					+ "\n" + "AMORTIZATION: " + Extensions.amortizationFormattedDataArray.get(month);
		
		return answer;
	}
	
	public String showDataToEvaluateSummary() {
		
		String answer = "";

		answer += ("SUMMARY: "
				+ "\n" + "	Time Lapse : " + Extensions.creditTimeLapse + " Months"
				+ "\n" + "	Interest : " + Extensions.percentageFormatter.format(Extensions.creditInterest)
				+ "\n" + "	Investment : "  + Extensions.currencyFormatter.format(Extensions.creditInvestment)
				+ "\n" + "	Effective Rate : "  + Extensions.percentageFormatter.format(Extensions.creditEffectiveRate)
				+ "\n" + "	Annuity Value : "  + Extensions.creditAnnuityValue
				+ "\n" + "	Fee Value : " + Extensions.currencyFormatter.format(Extensions.creditFeeValue)
				);
		
		return answer;
	}
}
