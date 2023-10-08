package graph;

import java.util.*;

public class RottingOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 2}, {1, 1}, {0, 0}, {2, 0}}));
    }

    static int[][] visited;
    static Queue<List<Integer>> bfsQueue = new LinkedList<>();
    static Queue<Integer> timeQueue = new LinkedList<>();
    ;

    public static int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    bfsQueue.add(new ArrayList<>(Arrays.asList(i, j)));
                    timeQueue.add(0);
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0)
            return 0;
        return findTimeForOrangesRotting(grid);
    }

    public static int findTimeForOrangesRotting(int[][] grid) {
        int poppedLength = 0;
        while (!bfsQueue.isEmpty()) {
            List<Integer> poppedIndex = bfsQueue.poll();
            poppedLength = timeQueue.poll();
            int i = poppedIndex.get(0);
            int j = poppedIndex.get(1);

            if ((i - 1) >= 0 && visited[i - 1][j] != 1 && grid[i - 1][j] == 1) {
                visited[i - 1][j] = 1;
                bfsQueue.add(new ArrayList<>(Arrays.asList(i - 1, j)));
                timeQueue.add(poppedLength + 1);
            }
            if ((i + 1) < grid.length && visited[i + 1][j] != 1 && grid[i + 1][j] == 1) {
                visited[i + 1][j] = 1;
                bfsQueue.add(new ArrayList<>(Arrays.asList(i + 1, j)));
                timeQueue.add(poppedLength + 1);
            }
            if ((j - 1) >= 0 && visited[i][j - 1] != 1 && grid[i][j - 1] == 1) {
                visited[i][j - 1] = 1;
                bfsQueue.add(new ArrayList<>(Arrays.asList(i, j - 1)));
                timeQueue.add(poppedLength + 1);
            }
            if ((j + 1) < grid[0].length && visited[i][j + 1] != 1 && grid[i][j + 1] == 1) {
                visited[i][j + 1] = 1;
                bfsQueue.add(new ArrayList<>(Arrays.asList(i, j + 1)));
                timeQueue.add(poppedLength + 1);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    return -1;
                }
            }
        }
        return poppedLength;
    }
}
