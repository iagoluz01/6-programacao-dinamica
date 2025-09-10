package editdistance;

public class BruteForceEditDistance {
    private long iterations = 0;

    public int calculate(String str1, String str2) {
        return editDistanceRecursive(str1, str2, str1.length(), str2.length());
    }

    private int editDistanceRecursive(String str1, String str2, int m, int n) {
        iterations++;
        
        if (m == 0) return n;
        if (n == 0) return m;

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDistanceRecursive(str1, str2, m - 1, n - 1);

        return 1 + Math.min(
            editDistanceRecursive(str1, str2, m, n - 1),      // Insert
            Math.min(
                editDistanceRecursive(str1, str2, m - 1, n),  // Remove
                editDistanceRecursive(str1, str2, m - 1, n - 1) // Replace
            )
        );
    }

    public long getIterations() {
        return iterations;
    }

    public void resetIterations() {
        iterations = 0;
    }
}