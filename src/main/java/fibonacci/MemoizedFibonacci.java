package fibonacci;

public class MemoizedFibonacci {
    private long[] memo;
    private long iterations = 0;

    public long fibonacci(int n) {
        memo = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            iterations++;
            memo[i] = -1;
        }
        return lookupFibo(n);
    }

    private long lookupFibo(int n) {
        iterations++;
        if (memo[n] >= 0) {
            return memo[n];
        }
        if (n <= 1) {
            memo[n] = n;
        } else {
            memo[n] = lookupFibo(n - 1) + lookupFibo(n - 2);
        }
        return memo[n];
    }

    public long getIterations() {
        return iterations;
    }

    public void resetIterations() {
        iterations = 0;
    }
}