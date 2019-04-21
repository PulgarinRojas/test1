package Controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class Extensions {
	
	public static String oneDriveFolder = System.getProperty ("user.home") + "/OneDrive/" + "FilesToRead Eclipse/";
	public static int creditTimeLapse; // Default 48
	public static double creditInvestment; // Default 28070000
	public static double creditInterest; // Default 0.2343
	public static double creditEffectiveRate;
	public static double creditAnnuityValue;
	public static double creditFeeValue;

	public static String allCreditData = "Fee" + "	|	" 
										+ "Balance" + "	|	" 
										+ "Fee Amount" + "	|	"
										+ "Interest" + "	|	"
										+ "Amortization" + "\n";
	
	public static ArrayList<String> balanceDataArray = new ArrayList<String>();
	public static ArrayList<String> feeAmountDataArray = new ArrayList<String>();
	public static ArrayList<String> interestFormattedDataArray = new ArrayList<String>();
	public static ArrayList<String> amortizationFormattedDataArray = new ArrayList<String>();

	public static Locale locale = new Locale("en", "US");      
	public static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	public static NumberFormat percentageFormatter = NumberFormat.getPercentInstance(locale);

}
