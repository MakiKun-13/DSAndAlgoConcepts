package dp;

public class MinimumPathSumBacktracking {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][] {{1,2}, {2,1}}));
    }
    static int[][] dp;
    public static int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        return findMinPathSum(grid.length-1, grid[0].length-1, grid);
    }

    public static int findMinPathSum(int i, int j, int[][] grid) {
        if(i==0 && j==0) {
            return grid[i][j];
        }
        if(dp[i][j]!=0) {
            return dp[i][j];
        }
        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        if(i-1>=0) {
            left = grid[i][j] + findMinPathSum(i-1, j, grid);
        }
        if(j-1>=0) {
            up = grid[i][j] + findMinPathSum(i, j-1, grid);
        }
        dp[i][j] = Math.min(left, up);
        return dp[i][j];
    }
}
/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n*n)
 */