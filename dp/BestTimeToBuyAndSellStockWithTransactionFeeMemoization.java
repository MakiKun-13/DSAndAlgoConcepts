package dp;

public class BestTimeToBuyAndSellStockWithTransactionFeeMemoization {
    public static void main(String[] args) {
        maxProfit(new int[] {1,3,2,8,4,9}, 2);
    }
    static int[][] DP;
    public static int maxProfit(int[] prices, int fee) {
        DP = new int[prices.length][2];
        return findMaxProfit(prices, fee, 0, 0);
    }
    public static int findMaxProfit(int[] prices, int fee, int index, int bought) {
        if(index==prices.length)
            return 0;
        if(DP[index][bought] != 0)
            return DP[index][bought];
        if(bought==0) {
            return DP[index][bought] = Math.max(findMaxProfit(prices, fee, index+1, bought),
                    findMaxProfit(prices, fee, index+1, 1) - prices[index]);
        }
        else {
            return DP[index][bought] =  Math.max(findMaxProfit(prices, fee, index+1, bought), findMaxProfit(prices, fee, index+1, 0) + prices[index] - fee);
        }
    }
}
/**
 We have 2D array to keep track of profit if bought and profit if not bought
 */