package dp;

import java.util.Arrays;

public class FibonacciMemoization {
    static int[] dp;
    public static void main(String args[]) {
        int n = 5;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(findFibonacci(n, dp));
    }

    private static int findFibonacci(int n, int[] dp) {
        if(n<=1)
            return n;
        if(FibonacciMemoization.dp[n]!=-1)
            return dp[n];
        return dp[n] = findFibonacci(n-1, dp) +findFibonacci(n-2, dp);
    }
}
/**
 * Solved with Memoization
 * Time Complexity: O(n)
 * Space complexity: O(n) + O(N) (for recursion and array)
 */
