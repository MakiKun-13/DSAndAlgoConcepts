package dp;

public class UniquePathsII {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0,0,0},{0,0,0,0,1},{0,0,0,1,0},{0,0,1,0,0}}));
    }
    static int[][] DP;
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        DP = new int[obstacleGrid.length][obstacleGrid[0].length];
        return findUniquePaths(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1);
    }
    public static int findUniquePaths(int[][] obstacleGrid, int i, int j) {
        if(obstacleGrid[i][j]==1) {
            return 0;
        }
        if(i==0 && j==0) {
            return 1;
        }
        if(DP[i][j]!=0) {
            return DP[i][j];
        }

        int left = 0;
        int up = 0;
        if(i-1>=0) {
            left = findUniquePaths(obstacleGrid, i-1, j);
        }
        if(j-1>=0) {
            up = findUniquePaths(obstacleGrid, i, j-1);
        }

        DP[i][j] = left + up;
        return DP[i][j];
    }
}
