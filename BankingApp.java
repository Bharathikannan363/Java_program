import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be greater than 0"
            );
        }

        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be greater than 0"
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient balance"
            );
        }

        balance -= amount;
    }

    double getBalance() {
        return balance;
    }

    String getAccountNumber() {
        return accountNumber;
    }

    String getHolderName() {
        return holderName;
    }
}


public class BankingApp extends JFrame implements ActionListener {

    JTextField accountField;
    JTextField nameField;
    JTextField amountField;

    JButton depositButton;
    JButton withdrawButton;
    JButton balanceButton;
    JButton clearButton;

    JTextArea outputArea;

    BankAccount account;

    ArrayList<String> transactions = new ArrayList<>();


    BankingApp() {

        setTitle("Simple Banking System");
        setSize(500, 500);
        setLayout(new BorderLayout(10, 10));


        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        inputPanel.setBorder(
            BorderFactory.createTitledBorder("Account Details")
        );

        inputPanel.add(new JLabel("Account Number:"));

        accountField = new JTextField();
        inputPanel.add(accountField);

        inputPanel.add(new JLabel("Holder Name:"));

        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Amount:"));

        amountField = new JTextField();
        inputPanel.add(amountField);

        add(inputPanel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel(
            new GridLayout(1, 4, 5, 5)
        );

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        balanceButton = new JButton("Balance");
        clearButton = new JButton("Clear");

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(balanceButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);



        outputArea = new JTextArea();
        outputArea.setEditable(false);

        outputArea.setBorder(
            BorderFactory.createTitledBorder("Transaction Details")
        );

        add(
            new JScrollPane(outputArea),
            BorderLayout.SOUTH
        );


        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        balanceButton.addActionListener(this);
        clearButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    void createAccount() {

        if (account == null) {

            String accountNumber =
                accountField.getText().trim();

            String name =
                nameField.getText().trim();

            if (accountNumber.isEmpty() || name.isEmpty()) {

                throw new IllegalArgumentException(
                    "Enter account number and holder name"
                );
            }

            account = new BankAccount(
                accountNumber,
                name,
                0
            );
        }
    }


    // Handle button events
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // Deposit
            if (e.getSource() == depositButton) {

                createAccount();

                double amount =
                    Double.parseDouble(
                        amountField.getText()
                    );

                account.deposit(amount);

                transactions.add(
                    "Deposited: ₹" + amount
                );

                outputArea.append(
                    "Deposit successful: ₹" +
                    amount + "\n"
                );
            }


            // Withdraw
            else if (e.getSource() == withdrawButton) {

                createAccount();

                double amount =
                    Double.parseDouble(
                        amountField.getText()
                    );

                account.withdraw(amount);

                transactions.add(
                    "Withdrawn: ₹" + amount
                );

                outputArea.append(
                    "Withdrawal successful: ₹" +
                    amount + "\n"
                );
            }


            // Balance
            else if (e.getSource() == balanceButton) {

                createAccount();

                outputArea.append(
                    "\nAccount Number: " +
                    account.getAccountNumber() +
                    "\nHolder Name: " +
                    account.getHolderName() +
                    "\nCurrent Balance: ₹" +
                    account.getBalance() +
                    "\n-------------------------\n"
                );
            }


            // Clear
            else if (e.getSource() == clearButton) {

                accountField.setText("");
                nameField.setText("");
                amountField.setText("");

                outputArea.setText("");

                account = null;
                transactions.clear();
            }

        }

        catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
            );
        }

        catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Banking Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // Main method
    public static void main(String[] args) {

        new BankingApp();
    }
}