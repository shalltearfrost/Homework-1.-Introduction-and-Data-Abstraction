public class BankAccountClient {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alice", 100.0);
        System.out.println(account);

        account.deposit(250.50);
        System.out.println("after deposit: " + account.balance());

        account.withdraw(75.25);
        System.out.println("after withdrawal: " + account.balance());

        try {
            account.withdraw(1000.0);
        } catch (IllegalStateException e) {
            System.out.println("rejected: " + e.getMessage());
        }

        try {
            account.deposit(-5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("rejected: " + e.getMessage());
        }

        System.out.println(account);
    }
}
