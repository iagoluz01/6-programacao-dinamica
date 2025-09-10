package knapsack;

public class DynamicKnapsack {
    private long iterations = 0;

    public int solve(Item[] items, int capacity) {
        int n = items.length - 1; // Ignore index 0
        int[][] maxTab = new int[n + 1][capacity + 1];

        // Initialize first row and column to 0
        for (int j = 0; j <= capacity; j++) {
            iterations++;
            maxTab[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            iterations++;
            maxTab[i][0] = 0;
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                iterations++;
                if (items[i].getWeight() <= j) {
                    maxTab[i][j] = Math.max(
                        maxTab[i-1][j],
                        items[i].getValue() + maxTab[i-1][j - items[i].getWeight()]
                    );
                } else {
                    maxTab[i][j] = maxTab[i-1][j];
                }
            }
        }

        return maxTab[n][capacity];
    }

    public long getIterations() {
        return iterations;
    }

    public void resetIterations() {
        iterations = 0;
    }
}