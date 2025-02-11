import java.util.*;
public class OBST_DP {

    public static int optimalBST(int[] keys, int[] freq, int n) {
        // dp[i][j] will hold the minimum cost of a BST for keys[i..j]
        int[][] dp = new int[n][n];

        // Prefix sum array to calculate the sum of frequencies in O(1)
        int[] sumFreq = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sumFreq[i] = sumFreq[i - 1] + freq[i - 1];
        }

        // Fill diagonal elements (single keys as BST)
        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
        }

        // Fill the DP table for subtrees of increasing length
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                // Initialize cost to maximum possible value
                dp[i][j] = Integer.MAX_VALUE;

                // Try making each key in keys[i..j] the root
                for (int root = i; root <= j; root++) {
                    int costLeft = (root > i) ? dp[i][root - 1] : 0;
                    int costRight = (root < j) ? dp[root + 1][j] : 0;

                    // Total cost including the current root
                    int totalCost = costLeft + costRight + sumFreq[j + 1] - sumFreq[i];

                    // Update minimum cost
                    dp[i][j] = Math.min(dp[i][j], totalCost);
                }
            }
        }

        // The result is the cost of the BST for keys[0..n-1]
        return dp[0][n - 1];
    }
        public static void main(String[] args) {
        int[] keys = {10, 12, 20};
        int[] freq = {34, 8, 50};

        int n = keys.length;

        int cost = optimalBST(keys, freq, n);
        System.out.println("Cost of the Optimal BST: " + cost);
    }
}
