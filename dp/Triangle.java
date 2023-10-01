package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String args[]) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3,4));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6,5,7));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(new ArrayList<> (Arrays.asList(list1, list2, list3, list4))));
    }
    static int[][] DP;
    public static int minimumTotal(List<List<Integer>> triangle) {
        DP = new int[triangle.size()][triangle.size()+1];
        for (int[] ints : DP) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        return findMinimumTotal(triangle, 0, 0);
    }
    public static int findMinimumTotal(List<List<Integer>> triangle, int i, int j) {
        if(i==triangle.size()-1) {
            return triangle.get(i).get(j);
        }
        if(DP[i][j] != Integer.MAX_VALUE) {
            return DP[i][j];
        }
        int min = Math.min(findMinimumTotal(triangle, i+1, j), findMinimumTotal(triangle, i+1, j+1)) + triangle.get(i).get(j);
        DP[i][j] = min;
        return min;
    }
}
