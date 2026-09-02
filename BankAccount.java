public class BankAccount {

    private final String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("initial balance cannot be negative");
        }
        this.owner = owner;
        this.balance = initialBalance;
    }

    public BankAccount(String owner) {
        this(owner, 0.0);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("deposit must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("withdrawal must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("insufficient funds");
        }
        balance -= amount;
    }

    public double balance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", owner, balance);
    }
}
