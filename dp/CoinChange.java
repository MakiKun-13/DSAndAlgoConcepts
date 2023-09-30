package dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String args[]) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
    }
    static Map<Integer,Integer> amountMap;
    public static int coinChange(int[] coins, int amount) {
        amountMap = new HashMap<>();
        return findNumberOfCoins(coins, amount);
    }

    public static int findNumberOfCoins(int[] coins, int amount) {
        if(amount==0) {
            return 0;
        }
        if(amountMap.containsKey(amount)) {
            return amountMap.get(amount);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++) {
            if(coins[i]<= amount) {
                int nextCoins = findNumberOfCoins(coins, amount-coins[i]);
                if(nextCoins==-1)
                    continue;
                min = Math.min(min, (1 + nextCoins));
            }
        }
        if(min==Integer.MAX_VALUE) {
            amountMap.put(amount, -1);
            return -1;
        }
        amountMap.put(amount, min);
        return min;
    }
}
