package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String args[]) {
        System.out.println(totalNQueens(4));
    }

    static int count = 0;
    public static int totalNQueens(int n) {
        if(n==0) {
            return 0;
        }
        List<List<Integer>> posOfAllQueens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            findQueensPos(n, posOfAllQueens, i, 0);
        }
        return count;
    }

    public static void findQueensPos(int n, List<List<Integer>> posOfAllQueens, int row, int col) {
        for (List list : posOfAllQueens) {
            int i = (int) list.get(0);
            int j = (int) list.get(1);
            if (row == i || col == j || Math.abs(i - row) == Math.abs(col - j)) {
                return;
            }
        }
        if (n - 1 == col) {
            count++;
            return;
        }
        posOfAllQueens.add(new ArrayList<>(Arrays.asList(row, col)));
        for (int i = 0; i < n; i++) {
            findQueensPos(n, posOfAllQueens, i, col + 1);
        }
        posOfAllQueens.remove(posOfAllQueens.size() - 1);
    }
}
