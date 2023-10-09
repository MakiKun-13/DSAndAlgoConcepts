package graph;

public class NumberOfProvincesSolutionI {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
    }
    static int[][] visited;
    static int provinces = 0;
    public static int findCircleNum(int[][] isConnected) {
        visited = new int[isConnected.length][isConnected[0].length];
        for(int i=0; i<isConnected.length; i++) {
            for(int j=0; j<isConnected[0].length; j++) {
                if(visited[i][j]==0 && isConnected[i][j]==1) {
                    visited[i][j] = 1;
                    findNumberOfProvinces(isConnected, i);
                    provinces++;
                }
            }
        }
        return provinces;
    }
    public static void findNumberOfProvinces(int[][] isConnected, int iIndex) {
        for(int i=0; i<isConnected.length; i++) {
            if(isConnected[iIndex][i]==1 && visited[iIndex][i]==0) {
                visited[iIndex][i] = 1;
                findNumberOfProvinces(isConnected, i);
            }
        }
    }
}
