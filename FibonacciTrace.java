public class FibonacciTrace {

    public static void main(String[] args) {
        trace();
    }

    static void trace() {
        int a = 1;
        int b = 1;
        int pass = 0;

        System.out.printf("%-6s %-3s %s%n", "pass", "a", "b");
        System.out.printf("%-6s %-3d %d%n", "start", a, b);

        while (b < 20) {
            b = a + b;
            a = b - a;
            System.out.printf("%-6d %-3d %d%n", ++pass, a, b);
        }

        System.out.println();
        System.out.println(a + ", " + b);
    }
}
