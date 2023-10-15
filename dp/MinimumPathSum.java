package dp;

public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][] {{1,2}, {2,1}}));
    }
    static int[][] dp;
    public static int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        return findMinPathSum(0, 0, grid);
    }

    public static int findMinPathSum(int i, int j, int[][] grid) {
        if(i==grid.length-1 && j==grid[0].length-1) {
            return grid[i][j];
        }
        if(dp[i][j]!=0) {
            return dp[i][j];
        }
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(i+1<grid.length) {
            down = grid[i][j] + findMinPathSum(i+1, j, grid);
        }
        if(j+1<grid[0].length) {
            right = grid[i][j] + findMinPathSum(i, j+1, grid);
        }
        dp[i][j] = Math.min(down, right);
        return dp[i][j];
    }
}
/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 */
