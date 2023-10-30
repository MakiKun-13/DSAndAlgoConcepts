package dp;

import java.util.Arrays;

public class LongestCommonSubsequenceMemoization {
    int DP[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        DP = new int[m][n];
        for(int[] row: DP) {
            Arrays.fill(row, -1);
        }
        return findLongestSubsequence(m-1, n-1, text1, text2);
    }
    public int findLongestSubsequence(int index1, int index2, String text1, String text2) {
        if(index1<0 || index2<0) {
            return 0;
        }
        if(DP[index1][index2]!=-1) {
            return DP[index1][index2];
        }
        if(text1.charAt(index1) == text2.charAt(index2)) {
            DP[index1][index2] = 1 + findLongestSubsequence(index1-1, index2-1, text1, text2);
            return DP[index1][index2];
        }
        DP[index1][index2] = Math.max(findLongestSubsequence(index1-1, index2, text1, text2), findLongestSubsequence(index1, index2-1, text1, text2));
        return DP[index1][index2];
    }
}
/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n) + O(m+n)
 */
