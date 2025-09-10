package fibonacci;

public class RecursiveFibonacci {
    private long iterations = 0;

    public long fibonacci(int n) {
        iterations++;
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long getIterations() {
        return iterations;
    }

    public void resetIterations() {
        iterations = 0;
    }
}