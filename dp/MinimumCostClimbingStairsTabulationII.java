package dp;

public class MinimumCostClimbingStairsTabulationII {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[] {10,15,20});
    }
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length==2)
            return Math.min(cost[0], cost[1]);
        int prev2 = cost[0];
        int prev = cost[1];
        for(int i=2; i<cost.length; i++) {
            int curr = cost[i] + Math.min(prev, prev2);
            prev2=prev;
            prev=curr;
        }
        return Math.min(prev, prev2);
    }
}
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */