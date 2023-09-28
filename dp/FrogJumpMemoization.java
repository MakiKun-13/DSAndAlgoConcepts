package dp;

import java.util.Arrays;

public class FrogJump {
    public static void main(String args[]) {
        System.out.println(frogJump(4, new int[] {10, 20, 30, 10}));
    }
    static int[] dp;
    public static int frogJump(int n, int heights[]) {
        dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        return findMinEnergy(n-1, heights);
    }

    public static int findMinEnergy(int n, int heights[]) {
        if(dp[n]!=-1)
            return dp[n];
        if(n==0)
            return 0;
        int left = findMinEnergy(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1)
            right = findMinEnergy(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        dp[n] = Math.min(left, right);
        return dp[n];
    }
}
/**
 *
 */
