package graph;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        return findIslands(grid);
    }
    public static int findIslands(char[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    count++;
                    countIsland(grid, i, j);
                }
            }
        }
        return count;
    }
    public static void countIsland(char[][] grid, int i, int j) {
        if(grid[i][j]=='0')
            return;
        grid[i][j]='0';
        if(i+1 <grid.length)
            countIsland(grid, i+1, j);
        if(i-1>=0)
            countIsland(grid, i-1, j);
        if(j+1 <grid[0].length)
            countIsland(grid, i, j+1);
        if(j-1>=0)
            countIsland(grid, i, j-1);
    }
}
