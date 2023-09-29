package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }
    static int dp[][];
    public static int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int row=0; row<nums.length;row++) {
            Arrays.fill(dp[row], -1);
        }
        if(nums.length==1 || nums.length==0) {
            return nums.length;
        }
        return findLengthOfLIS(nums, 0, -1);
    }
    public static int findLengthOfLIS(int[] nums, int i, int lastPickedIndex) {
        if(i==nums.length) {
            return 0;
        }
        if(dp[i][lastPickedIndex+1]!=-1) {
            return dp[i][lastPickedIndex+1];
        }
        int notPick = findLengthOfLIS(nums, i+1, lastPickedIndex);
        int pick = Integer.MIN_VALUE;
        if(lastPickedIndex==-1 || nums[i] > nums[lastPickedIndex]) {
            pick = 1 + findLengthOfLIS(nums, i+1, i);
        }
        dp[i][lastPickedIndex+1] = Math.max(pick, notPick);
        return dp[i][lastPickedIndex+1];
    }
}
/**
 * Memoization
 * Time Complexity: O(n*n)
 * Space Complexity: O(n) + O(n*n) (For the 2d array)
 */
