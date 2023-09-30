package dp;

public class JumpGameII {
    static int[] DP;
    public static void main(String args[]) {
        System.out.println(jump(new int[] {2,3,0,1,4}));
    }
    public static int jump(int[] nums) {
        DP = new int[nums.length];
        return findMinJumps(nums, 0);
    }
    public static int findMinJumps(int[] nums, int index) {
        if(index >= nums.length-1) {
            return 0;
        }
        if(DP[index]!=0) {
            return DP[index];
        }
        int mini = Integer.MAX_VALUE;
        for(int i=index+1; i<=(index+nums[index]); i++) {
            int nextVal = findMinJumps(nums, i);
            if(nextVal == Integer.MAX_VALUE)
                continue;
            mini = Math.min(mini, (1 + nextVal));
        }
        DP[index] = mini;
        return mini;
    }
}
