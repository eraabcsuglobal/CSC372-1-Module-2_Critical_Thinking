
public class BankAccount {
	
	protected double accountBalance;
	public double getBalance() {
		return accountBalance;
	}
	
	// deposit method
	void deposit(double amountToAdd){
		accountBalance += amountToAdd;
	}
	
	// withdrawal method
	public void withdrawal(double amountToSubtract) {
		accountBalance -= amountToSubtract;
	}
}

