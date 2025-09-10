import fibonacci.*;
import knapsack.*;
import editdistance.*;

public class Main {
    public static void main(String[] args) {
        testFibonacci();
        testKnapsack();
        testEditDistance();
    }

    private static void testFibonacci() {
        System.out.println("=== Fibonacci Tests ===");
        int[] tests = {4, 8, 16, 32, 128, 1000, 10000};
        
        RecursiveFibonacci rf = new RecursiveFibonacci();
        IterativeFibonacci if1 = new IterativeFibonacci();
        MemoizedFibonacci mf = new MemoizedFibonacci();

        System.out.printf("%-15s %-15s %-15s %-15s%n", "N", "Recursive", "Iterative", "Memoized");
        System.out.println("-".repeat(60));

        for (int n : tests) {
            if (n <= 32) { // Recursive only for small numbers
                rf.resetIterations();
                long recResult = rf.fibonacci(n);
                long recIter = rf.getIterations();
                System.out.printf("%-15d %-15d ", n, recIter);
            } else {
                System.out.printf("%-15d %-15s ", n, "N/A");
            }

            if1.resetIterations();
            long iterResult = if1.fibonacci(n);
            long iterIter = if1.getIterations();

            mf.resetIterations();
            long memoResult = mf.fibonacci(n);
            long memoIter = mf.getIterations();

            System.out.printf("%-15d %-15d%n", iterIter, memoIter);
        }
    }

    private static void testKnapsack() {
        System.out.println("\n=== Knapsack Tests ===");
        
        // Test case from class
        Item[] items = new Item[5]; // 0 index will be ignored
        items[0] = new Item(0, 0);  // dummy item
        items[1] = new Item(2, 3);
        items[2] = new Item(3, 4);
        items[3] = new Item(4, 5);
        items[4] = new Item(5, 6);

        int capacity = 10;

        BruteForceKnapsack bfk = new BruteForceKnapsack();
        DynamicKnapsack dk = new DynamicKnapsack();

        bfk.resetIterations();
        int bfResult = bfk.solve(items, capacity);
        long bfIter = bfk.getIterations();

        dk.resetIterations();
        int dkResult = dk.solve(items, capacity);
        long dkIter = dk.getIterations();

        System.out.println("Brute Force Result: " + bfResult + " (iterations: " + bfIter + ")");
        System.out.println("Dynamic Result: " + dkResult + " (iterations: " + dkIter + ")");
    }

    private static void testEditDistance() {
        System.out.println("\n=== Edit Distance Tests ===");
        
        String[][] testCases = {
            {"Casablanca", "Portentoso"},
            {
                "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
                "simplify the build processes in the Jakarta Turbine project. There were several " +
                "projects, each with their own Ant build files, that were all slightly different." +
                "JARs were checked into CVS. We wanted a standard way to build the projects, a clear " +
                "definition of what the project consisted of, an easy way to publish project information " +
                "and a way to share JARs across several projects. The result is a tool that can now be " +
                "used for building and managing any Java-based project. We hope that we have created " +
                "something that will make the day-to-day work of Java developers easier and generally help " +
                "with the comprehension of any Java-based project.",
                
                "This post is not about deep learning. But it could be might as well. This is the power of " +
                "kernels. They are universally applicable in any machine learning algorithm. Why you might " +
                "ask? I am going to try to answer this question in this article." +
                "Go to the profile of Marin Vlastelica Pogančić" +
                "Marin Vlastelica Pogančić Jun"
            }
        };

        BruteForceEditDistance bfed = new BruteForceEditDistance();
        DynamicEditDistance ded = new DynamicEditDistance();

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\nTest Case " + (i + 1) + ":");
            String str1 = testCases[i][0];
            String str2 = testCases[i][1];

            if (str1.length() < 50) {
                System.out.println("String 1: " + str1);
                System.out.println("String 2: " + str2);
            } else {
                System.out.println("(Large text strings...)");
            }

            if (str1.length() * str2.length() < 1000) { // Only use brute force for small strings
                bfed.resetIterations();
                int bfResult = bfed.calculate(str1, str2);
                long bfIter = bfed.getIterations();
                System.out.println("Brute Force Distance: " + bfResult + " (iterations: " + bfIter + ")");
            } else {
                System.out.println("Brute Force: N/A (too large)");
            }

            ded.resetIterations();
            int dResult = ded.calculate(str1, str2);
            long dIter = ded.getIterations();
            System.out.println("Dynamic Distance: " + dResult + " (iterations: " + dIter + ")");
        }
    }
}