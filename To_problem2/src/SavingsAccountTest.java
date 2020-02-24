
public class SavingsAccountTest {
	
	public static void main(String[] args) {
		
//		initialize $2000 and $3000 Savings account balances
		SavingsAccount Saver1 = new SavingsAccount(2000.00);
		SavingsAccount Saver2 = new SavingsAccount(3000.00);
		
//		Set interest rate to 4%
		SavingsAccount.modifyInterestRate(4);
		
//		Print data for Saver 1
		System.out.println("Balance for Saver 1");
		
		for(int i = 0; i < 12; i++) {
//			calculate the monthly interest
			Saver1.calculateMonthlyInterest();
			System.out.println("Month " + (i+1) + ": \t");
			Saver1.displayBalance();
			System.out.printf("\n");
		}
		
		System.out.printf("\n\n");
		
//		Print data for Saver 2
		System.out.println("Balance for Saver 2");
		
		for(int i = 0; i < 12; i++) {
//			calculate the monthly interest
			Saver2.calculateMonthlyInterest();
			System.out.println("Month " + (i+1) + ": \t");
			Saver2.displayBalance();
			System.out.printf("\n");
		}
		
		System.out.printf("\n\n");
		
//		Set interest rate to 5%
		SavingsAccount.modifyInterestRate(5);
		
//		Calculate new monthly interest
		Saver1.calculateMonthlyInterest();
		Saver2.calculateMonthlyInterest();
		
//		Print Final data
		System.out.println("Saver 1 \t Month 13: \t");
		Saver1.displayBalance();
		
		System.out.printf("\n\n");
		
		System.out.println("Saver 2 \t Month 13: \t");
		Saver2.displayBalance();		

		
		
		
	}
}
