package dp;

import java.util.Arrays;

public class NinjaTrainingMemoization {
    public static void main(String[] args) {
        System.out.println(ninjaTraining(3, new int[][]{{1,2,5}, {3,1,1}, {3,3,3}}));
    }
    static int[][] dp;
    public static int ninjaTraining(int n, int points[][]) {
        dp = new int[n][4];
        for(int i=0; i<points.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return calculatePoints(points, n-1, 3, dp);
    }

    public static int calculatePoints(int[][] points, int day, int lastTask, int[][] dp) {
        if(dp[day][lastTask]!=-1) {
            return dp[day][lastTask];
        }
        if(day == 0) {
            int max = 0;
            for(int ind=0; ind<3; ind++) {
                if(ind!=lastTask) {
                    max = Math.max(max, points[0][ind]);
                }
            }
            dp[day][lastTask] = max;
            return max;
        }
        int max = 0;
        for(int ind=0; ind<3; ind++) {
            if(ind!=lastTask) {
                int currPoint = points[day][ind] + calculatePoints(points, day-1, ind, dp);
                max = Math.max(max, currPoint);
            }
        }
        dp[day][lastTask] = max;
        return max;
    }
}
/**
 * Memoization Solution
 */
