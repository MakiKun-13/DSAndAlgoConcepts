package graph;

import java.util.*;

/**
 * Using Khan's Algorithm (TopologicalSort BFS)
 */
public class DetectCycle {
    public static void main(String[] args) {
        System.out.println(findTopologicalOrder(new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>(List.of(2)),
                new ArrayList<>(List.of(3)), new ArrayList<>(List.of(4,5)), new ArrayList<>(List.of(2)),
                new ArrayList<>())), 6));
    }

    static boolean findTopologicalOrder(List<List<Integer>> adjList, int n) {
        int[] degree = new int[n];
        for(int i=0; i<n; i++) {
            for(int connection: adjList.get(i)) {
                degree[connection]++;
            }
        }
        Queue<Integer> bfsQueue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(degree[i]==0) {
                bfsQueue.add(i);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        while(!bfsQueue.isEmpty()) {
            int poppedNode = bfsQueue.poll();
            resultList.add(poppedNode);
            for(int connection : adjList.get(poppedNode)) {
                degree[connection]--;
                if(degree[connection]==0)
                    bfsQueue.add(connection);
            }
        }
        return (resultList.size()==n);
    }
}
