package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTopologicalOrder(new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(List.of(3)), new ArrayList<>(List.of(1)), new ArrayList<>(List.of(0)),
                new ArrayList<>(Arrays.asList(0, 2)))), 6)));
    }
    static int[] visited;
    public static int[] findTopologicalOrder(List<List<Integer>> adj, int v) {
        visited = new int[v];
        Stack<Integer> nodeStack = new Stack<>();
        for(int i=0; i<v; i++) {
            if(visited[i]==0) {
                dfs(adj, i, nodeStack);
            }
        }
        int[] ans = new int[v];
        int i=0;
        while(!nodeStack.isEmpty()) {
            ans[i] = nodeStack.peek();
            nodeStack.pop();
            i++;
        }
        return ans;
    }

    private static void dfs(List<List<Integer>> adj, int i, Stack<Integer> nodeStack) {
        visited[i] = 1;
        for(int j: adj.get(i)) {                            // Explore the node first
            if(visited[j]==0) {
                dfs(adj, j, nodeStack);
            }
        }
        nodeStack.push(i);                                  // Then add it into the Stack
    }
}
