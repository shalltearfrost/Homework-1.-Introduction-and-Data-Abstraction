public class CounterClient {

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        for (int i = 0; i < 10; i++) {
            if (Math.random() < 0.5) {
                heads.increment();
            } else {
                tails.increment();
            }
        }

        System.out.println(heads);
        System.out.println(tails);
        System.out.println("total flips: " + (heads.value() + tails.value()));
    }
}
