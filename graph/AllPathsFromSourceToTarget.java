package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = new int[][] {{4,3,1},{3,2,4},{3},{4}, {}};
        allPathsSourceTarget(graph);
    }
    public static void allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(graph, resultList, 0, new ArrayList<>());
        System.out.println(resultList);
    }
    public static void dfs(int[][] graph, List<List<Integer>> resultList, int root, List<Integer> currentPath) {
        currentPath.add(root);
        if(root==graph.length-1) {
            resultList.add(new ArrayList<>(currentPath));
            return;
        }
        if(graph[root].length == 0) {
            return;
        }
        for(int i: graph[root]) {
            dfs(graph, resultList, i, currentPath);
            currentPath.remove(currentPath.size()-1);
        }
    }
}
/**
 * Solved using DFS
 * Solved for aa directed acyclic graph (DAG), so no cycles
 * Source is the first node and destination is the last node
 *
 */
