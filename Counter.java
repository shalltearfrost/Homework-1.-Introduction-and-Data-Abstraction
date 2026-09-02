public class Counter {

    private final String name;
    private int count;

    public Counter(String name) {
        this.name = name;
    }

    public void increment() {
        count++;
    }

    public int value() {
        return count;
    }

    @Override
    public String toString() {
        return name + ": " + count;
    }
}
