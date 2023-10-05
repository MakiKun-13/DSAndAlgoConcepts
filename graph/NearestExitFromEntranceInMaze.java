package graph;

import java.util.*;

public class NearestExitFromEntranceInMaze {
    public static void main(String[] args) {
        System.out.println(nearestExit(new char[][] {{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},
                        {'+','.','+','.','+','.','+'},{'+','.','.','.','.','.','+'},{'+','+','+','+','.','+','.'}},
                new int[] {0, 1}));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<List<Integer>> bfsQueue = new LinkedList<>();
        bfsQueue.add(new ArrayList<>(Arrays.asList(entrance[0], entrance[1])));
        int level = -1;
        while(!bfsQueue.isEmpty()) {
            level++;
            int qSize = bfsQueue.size();
            for(int ind =0; ind<qSize; ind++){
                List<Integer> currentIndexes = bfsQueue.poll();
                int i = currentIndexes.get(0);
                int j = currentIndexes.get(1);
                if(!visited[i][j]) {
                    if ((i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1) && (i != entrance[0] || j != entrance[1])) {
                        return level;
                    }
                    visited[i][j] = true;
                    if (i - 1 >= 0 && maze[i - 1][j] == '.' && !visited[i - 1][j])
                        bfsQueue.add(new ArrayList<>(Arrays.asList(i - 1, j)));

                    if (j - 1 >= 0 && maze[i][j - 1] == '.' && !visited[i][j - 1])
                        bfsQueue.add(new ArrayList<>(Arrays.asList(i, j - 1)));

                    if (i + 1 < maze.length && maze[i + 1][j] == '.' && !visited[i + 1][j])
                        bfsQueue.add(new ArrayList<>(Arrays.asList(i + 1, j)));

                    if (j + 1 < maze[0].length && maze[i][j + 1] == '.' && !visited[i][j + 1])
                        bfsQueue.add(new ArrayList<>(Arrays.asList(i, j + 1)));}
            }
        }
        return -1;
    }
}
