package dp;

public class UniquePaths {
    public static void main(String args[]) {
        uniquePaths(3, 7);
    }
    static int[][] DP;
    public static int uniquePaths(int m, int n) {
        if(m==1 || n==1)
        {
            return 1;
        }
        DP = new int[m][n];
        return findUniquePaths(m-1, n-1);
    }
    public static int findUniquePaths(int i, int j) {
        if(i==0 && j==0) {
            return 1;
        }
        if(DP[i][j]!=0) {
            return DP[i][j];
        }
        int left = 0;
        int up = 0;
        if(i-1>=0) {
            up = findUniquePaths(i-1, j);
        }
        if(j-1>=0) {
            left = findUniquePaths(i, j-1);
        }
        DP[i][j] = left + up;
        return DP[i][j];
    }
}
