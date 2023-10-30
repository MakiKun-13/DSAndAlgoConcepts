package dp;

public class LongextCommonSubsequenceTabulation {
    int DP[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        DP = new int[m+1][n+1];

        for(int i=0; i<=m; i++) {
            DP[i][0] = 0;
        }
        for(int j=0; j<=n; j++) {
            DP[0][j] = 0;
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    DP[i][j] = 1 + DP[i-1][j-1];
                }
                else {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }
        return DP[m][n];
    }
}
/**
 * Solved with Tabulation
 *
 */
