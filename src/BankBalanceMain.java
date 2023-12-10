import javax.swing.JFrame;

public class BankBalanceMain {
	// NEW separated Main class to its own class
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		BankBalance myFrame = new BankBalance(bankAccount);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}