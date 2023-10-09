package graph;

public class NumberOfProvincesSolutionII {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
    }
    static int[] visited;
    static int provinces = 0;
    public static int findCircleNum(int[][] isConnected) {
        visited = new int[isConnected.length];
        for(int i=0; i<isConnected.length; i++) {
            if(visited[i]==0) {
                findNumberOfProvinces(isConnected, i);
                provinces++;
            }
        }
        return provinces;
    }
    public static void findNumberOfProvinces(int[][] isConnected, int iIndex) {
        visited[iIndex] = 1;
        for(int i=0; i<isConnected.length; i++) {
            if(isConnected[iIndex][i]==1 && visited[i]==0) {
                findNumberOfProvinces(isConnected, i);
            }
        }
    }
}
