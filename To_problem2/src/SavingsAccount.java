
public class SavingsAccount {
	
	private static double annualInterestRate = 0;	
	private double savingsBalance;
	
	public SavingsAccount(double Balance) {
		this.savingsBalance = Balance;	
	}
	
	public void calculateMonthlyInterest() {
		
		double interest;
		
//		Calculate monthly interest from savings balance and annual interest
		interest = (this.savingsBalance * (annualInterestRate/100)) / 12;
		this.savingsBalance += interest;
	}
	
	// initialize static variable
	public static void modifyInterestRate(double changeRate) {
		annualInterestRate = changeRate;
	}
	
//	Show balance
	public void displayBalance() {
		System.out.printf("$%.2f", this.savingsBalance);		
	}
}
