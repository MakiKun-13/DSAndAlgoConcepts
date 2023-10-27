package dp;

public class MinimumCostClimbingStairsTabulation {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[] {10,15,20});
    }
    static int[] DP;
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length==2)
            return Math.min(cost[0], cost[1]);
        DP = new int[cost.length];
        for(int i=0; i<cost.length; i++) {
            DP[i] = -1;
        }
        return Math.min(findCost(cost.length-1, cost), findCost(cost.length-2, cost));
    }
    public static int findCost(int index, int[] cost) {
        if(index<0)
            return 0;
        if(index==0 || index==1)
            return cost[index];
        if(DP[index]!=-1)
            return DP[index];
        DP[index] = cost[index] + Math.min(findCost(index-1, cost), findCost(index-2, cost));
        return DP[index];
    }
}
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */