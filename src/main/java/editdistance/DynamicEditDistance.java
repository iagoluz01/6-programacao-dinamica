package editdistance;

public class DynamicEditDistance {
    private long iterations = 0;

    public int calculate(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialize first row and column
        for (int i = 0; i <= m; i++) {
            iterations++;
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            iterations++;
            dp[0][j] = j;
        }

        // Fill the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                iterations++;
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],     // Remove
                        Math.min(
                            dp[i][j - 1], // Insert
                            dp[i - 1][j - 1] // Replace
                        )
                    );
                }
            }
        }

        return dp[m][n];
    }

    public long getIterations() {
        return iterations;
    }

    public void resetIterations() {
        iterations = 0;
    }
}