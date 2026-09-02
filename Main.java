import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static final Counter counter = new Counter("clicks");
    private static final BankAccount account = new BankAccount("Alice", 100.0);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("1 - Counter");
            System.out.println("2 - BankAccount");
            System.out.println("3 - Fibonacci trace");
            System.out.println("0 - exit");

            switch (prompt("> ")) {
                case "1" -> counterMenu();
                case "2" -> accountMenu();
                case "3" -> FibonacciTrace.trace();
                case "0" -> {
                    return;
                }
                default -> System.out.println("unknown option");
            }
        }
    }

    private static void counterMenu() {
        while (true) {
            System.out.println();
            System.out.println("1 - increment()");
            System.out.println("2 - value()");
            System.out.println("3 - toString()");
            System.out.println("0 - back");

            switch (prompt("> ")) {
                case "1" -> {
                    counter.increment();
                    System.out.println("incremented");
                }
                case "2" -> System.out.println("value = " + counter.value());
                case "3" -> System.out.println(counter);
                case "0" -> {
                    return;
                }
                default -> System.out.println("unknown option");
            }
        }
    }

    private static void accountMenu() {
        while (true) {
            System.out.println();
            System.out.println("1 - deposit(amount)");
            System.out.println("2 - withdraw(amount)");
            System.out.println("3 - balance()");
            System.out.println("4 - toString()");
            System.out.println("0 - back");

            switch (prompt("> ")) {
                case "1" -> runMoneyOp(true);
                case "2" -> runMoneyOp(false);
                case "3" -> System.out.println("balance = " + account.balance());
                case "4" -> System.out.println(account);
                case "0" -> {
                    return;
                }
                default -> System.out.println("unknown option");
            }
        }
    }

    private static void runMoneyOp(boolean isDeposit) {
        double amount;
        try {
            amount = Double.parseDouble(prompt("amount: "));
        } catch (NumberFormatException e) {
            System.out.println("not a number");
            return;
        }

        try {
            if (isDeposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
            System.out.println("ok, balance = " + account.balance());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("rejected: " + e.getMessage());
        }
    }

    private static String prompt(String label) {
        System.out.print(label);
        return in.hasNextLine() ? in.nextLine().trim() : "0";
    }
}
