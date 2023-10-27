package dp;

public class MinimumCostClimbingStairsMemoization {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[] {10,15,20});
    }
    static int[] DP;
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length==2)
            return Math.min(cost[0], cost[1]);
        DP = new int[cost.length];
        return Math.min(findCost(0, cost), findCost(1, cost));
    }
    public static int findCost(int index, int[] cost) {
        if(index>=cost.length)
            return 0;
        if(DP[index]!=0)
            return DP[index];
        DP[index] = cost[index] + Math.min(findCost(index+1, cost), findCost(index+2, cost));
        return DP[index];
    }
}
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
