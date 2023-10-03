package dp;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
    static int[][] DP;
    public static  int minDistance(String word1, String word2) {
        DP = new int[word1.length()][word2.length()];
        for(int[] row : DP) {
            Arrays.fill(row, -1);
        }
        return findMinDistance(word1, word2, 0, 0);
    }
    public static int findMinDistance(String word1, String word2, int i, int j) {
        if(j==word2.length()) {
            return word1.length() -i;
        }
        if(i == word1.length()) {
            return word2.length() -j;
        }
        if(DP[i][j]!=-1) {
            return DP[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)) {
            return findMinDistance(word1, word2, i+1, j+1);
        }
        else {
            int replace = 1 + findMinDistance(word1, word2, i + 1, j + 1);
            int insert = 1 + findMinDistance(word1, word2, i, j + 1);
            int remove = 1 + findMinDistance(word1, word2, i + 1, j);
            DP[i][j] = Math.min(Math.min(replace, insert), remove);
            return DP[i][j];
        }
    }
}
