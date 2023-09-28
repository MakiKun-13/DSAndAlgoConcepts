package dp;

public class FrogJumpTabulation {
    public static void main(String args[]) {
        System.out.println(frogJump(4, new int[] {10, 20, 30, 10}));
    }

    static int[] dp;
    public static int frogJump(int n, int heights[]) {
        dp =  new int[n];
        return findMinEnergy(n-1, heights);
    }

    public static int findMinEnergy(int n, int[] heights) {
        dp[0] = 0;
        for(int i=1; i<=n; i++) {
            int firstCase = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int secondCase = Integer.MAX_VALUE;
            if(i>1)
            secondCase = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] =  Math.min(firstCase, secondCase);
        }
        return dp[n];
    }
}
/**
 *
 *Time Complexity: O(n)
 *Space Complexity: O(n) (dp array)
 */
