package dp;

import java.util.Arrays;

public class HouseRobber {
    static int[] dp;
    public static void main(String args[]) {
        System.out.println(rob(new int[] {1,2,3,1}));
    }
    public static int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return findMaxAmount(nums, 0);
    }
    public static int findMaxAmount(int[] nums, int index) {
        if(index>=nums.length)
            return 0;
        if(dp[index] != -1) {
            return dp[index];
        }
        int pick = nums[index] + findMaxAmount(nums, index+2);
        int notPick = findMaxAmount(nums, index+1);
        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
}
