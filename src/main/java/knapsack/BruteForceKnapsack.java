package knapsack;

public class BruteForceKnapsack {
    private long iterations = 0;

    public int solve(Item[] items, int capacity) {
        return knapsack(items, capacity, items.length - 1);
    }

    private int knapsack(Item[] items, int capacity, int n) {
        iterations++;
        
        if (n < 0 || capacity <= 0) {
            return 0;
        }

        if (items[n].getWeight() > capacity) {
            return knapsack(items, capacity, n - 1);
        }

        return Math.max(
            items[n].getValue() + knapsack(items, capacity - items[n].getWeight(), n - 1),
            knapsack(items, capacity, n - 1)
        );
    }

    public long getIterations() {
        return iterations;
    }

    public void resetIterations() {
        iterations = 0;
    }
}