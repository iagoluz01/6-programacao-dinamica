package fibonacci;

public class IterativeFibonacci {
    private long iterations = 0;

    public long fibonacci(int n) {
        if (n <= 1) {
            iterations++;
            return n;
        }

        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            iterations++;
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    public long getIterations() {
        return iterations;
    }

    public void resetIterations() {
        iterations = 0;
    }
}