public class User {
    private String name;
    private String address;
    private String contactInfo;
    private double initialDeposit;
    private int accountNumber;

    // Constructor
    public User(String name, String address, String contactInfo, double initialDeposit, int accountNumber) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.initialDeposit = initialDeposit;
        this.accountNumber = accountNumber;
    }

    // Getters and Setters
    // Add getters and setters for all fields
}

public class Account {
    private User user;
    private double balance;

    // Constructor
    public Account(User user, double initialDeposit) {
        this.user = user;
        this.balance = initialDeposit;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdrawal method
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

   
}

public class BankingSystemPrototype {
    public static void main(String[] args) {
        // Create a new user
        User user = new User("John Doe", "123 Main St", "john.doe@example.com", 1000, 1001);

        // Create a new account for the user
        Account account = new Account(user, user.getInitialDeposit());

        // Deposit and withdraw from the account
        account.deposit(500);
        account.withdraw(200);

        // Display the account balance
        System.out.println("Account Balance: $" + account.getBalance());
    }
}
