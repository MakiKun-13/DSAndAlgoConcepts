package graph;

public class NumberOfProvincesSolutionII {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
    }
    static int[] visited;
    public static int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        visited = new int[isConnected.length];
        for(int i=0; i<isConnected.length; i++) {       // To loop through all the nodes
            if(visited[i]==0) {
                findNumberOfProvinces(isConnected, i);
                provinces++;
            }
        }
        return provinces;
    }
    public static void findNumberOfProvinces(int[][] isConnected, int iIndex) {
        visited[iIndex] = 1;
        for(int j=0; j<isConnected.length; j++) {       // To loop through all the nodes the given node is connected to
            if(isConnected[iIndex][j]==1 && visited[j]==0) {
                findNumberOfProvinces(isConnected, j);
            }
        }
    }
}
/**
 *
 * Time complexity: O(n^2)
 * Space complexity: O(n) For a 1-D array
 */
