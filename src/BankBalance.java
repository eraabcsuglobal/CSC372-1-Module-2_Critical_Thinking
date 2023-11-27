import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class BankBalance extends JFrame implements ActionListener {
	
	private JTextField accountBalanceField;
	private JTextField depositAmountField;
	private JTextField withdrawalAmountField;
	
	private JLabel accountBalanceLabel;
	private JLabel depositAmountLabel;
	private JLabel withdrawalAmountLabel;
	
	private JButton getBalanceButton;
	private JButton depositButton;
	private JButton withdrawalButton;
	
	private double accountBalance;
	
	BankBalance() {
		GridBagConstraints layoutConst = null;
		
		setTitle("Bank Balance");
		
		// set account balance amount to 0
		accountBalance = 0;
		
		// create labels
		accountBalanceLabel = new JLabel("Account balance:");
		depositAmountLabel = new JLabel("Enter deposit amount:");
		withdrawalAmountLabel = new JLabel("Enter withdrawl amount:");
		
		// create text fields
		accountBalanceField = new JTextField(10);
		accountBalanceField.setEditable(false);
		
		depositAmountField = new JTextField(10);
		depositAmountField.setEditable(true);
		
		withdrawalAmountField = new JTextField(10);
		withdrawalAmountField.setEditable(true);
		
		// create buttons and add listeners for functionality
		getBalanceButton = new JButton("Show My Balance");
		getBalanceButton.addActionListener(this);
		getBalanceButton.setActionCommand("Get Balance");
		
		depositButton = new JButton("Deposit Money");
		depositButton.addActionListener(this);
		depositButton.setActionCommand("Deposit");
		
		withdrawalButton = new JButton("Withdrawal Money");
		withdrawalButton.addActionListener(this);
		withdrawalButton.setActionCommand("Withdrawal");
		
		// create frame and add components using GridBagLayout
		setLayout(new GridBagLayout());
		
		// set up positioning for account balance label
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 1, 1);
		layoutConst.anchor = GridBagConstraints.LINE_START;
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.gridwidth = 1;
		add(accountBalanceLabel, layoutConst);
		
		// set up positioning for account balance field
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(1, 10, 10, 10);
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 1;
		add(accountBalanceField, layoutConst);
		
		// set up positioning for account account balance button
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(1, 10, 10, 10);
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		add(getBalanceButton, layoutConst);
		
		// set up positioning for account deposit label
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 1, 1);
		layoutConst.anchor = GridBagConstraints.LINE_START;
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 1;
		add(depositAmountLabel, layoutConst);
		
		// set up positioning for deposit field
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(1, 10, 1, 1);
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		layoutConst.gridx = 0;
		layoutConst.gridy = 4;
		layoutConst.gridwidth = 1;
		add(depositAmountField, layoutConst);
		
		// set up positioning for deposit button
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 1, 10, 10);
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.gridx = 1;
		layoutConst.gridy = 4;
		layoutConst.gridwidth = 1;
		add(depositButton, layoutConst);
		
		// set up positioning for withdrawal label
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 1, 10);
		layoutConst.anchor = GridBagConstraints.LINE_START;
		layoutConst.gridx = 2;
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 1;
		add(withdrawalAmountLabel, layoutConst);
		
		// set up positioning for withdrawal field
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(1, 10, 1, 10);
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		layoutConst.gridx = 2;
		layoutConst.gridy = 4;
		layoutConst.gridwidth = 1;
		add(withdrawalAmountField, layoutConst);
		
		//  set up positioning for withdrawal button
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(1, 10, 1, 10);
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.gridx = 3;
		layoutConst.gridy = 4;
		layoutConst.gridwidth = 1;
		add(withdrawalButton, layoutConst);
	
		
		// show account balance in field panel
		accountBalanceField.setText(Double.toString(getBalance()));
		
		
		// create functionality to show the current balance after the user closes the application
		// How to close AWT Window in Java. JavaTPoint. https://www.javatpoint.com/java-close-awt-window
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				JOptionPane.showMessageDialog(BankBalance.this, "Current Balance: $" + getBalance(), "Close Bank Application", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	
	
	// method to get account balance
	double getBalance() {
		return accountBalance;
	}
	
	// deposit method
	void deposit(double amountToAdd){
		accountBalance += amountToAdd;
	}
	
	// withdrawal method
	void withdrawal(double amountToSubtract) {
		accountBalance -= amountToSubtract;
	}
	
	// functionality for button interactions
	// source: https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/awt/event/ActionEvent.html#getActionCommand()
	@Override
	public void actionPerformed(ActionEvent event) {
		String userInput;
		double amountEntered;
		
		// if user clicks deposit button, call deposit() method and then clear the entry in the field
		if ("Deposit".equals(event.getActionCommand()))
		{
			userInput = depositAmountField.getText();	
			amountEntered = Double.parseDouble(userInput);
			deposit(amountEntered);
			depositAmountField.setText(Double.toString(0.00));
		}
		// if user clicks withdrawal button, call withdrawal() method and then clear the entry in the field
		else if ("Withdrawal".equals(event.getActionCommand()))
		{
			userInput = withdrawalAmountField.getText();
			amountEntered = Double.parseDouble(userInput);
			withdrawal(amountEntered);
			withdrawalAmountField.setText(Double.toString(0.00));
		}
		// if user clicks Show My Balance button, return the balance amount and show in the text field
		else if ("Get Balance".equals(event.getActionCommand()))
		{
			accountBalanceField.setText(Double.toString(getBalance()));
		}
	}
	
	public static void main(String[] args) {
		BankBalance myFrame = new BankBalance();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);
	}

}