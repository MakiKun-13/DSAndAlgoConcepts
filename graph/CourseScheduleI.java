package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Using Khan's algorithm
 */
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] {{1,0}, {0,1}}));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        return findIfCanFinish(numCourses, prerequisites);
    }
    public static boolean findIfCanFinish(int numCourses, int[][] prerequisites) {
        //Creating the adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] degree = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            for(int j: adjList.get(i)) {
                degree[j]++;
            }
        }

        Queue<Integer> bfsQueue = new LinkedList<>();
        for(int i=0; i<degree.length; i++) {
            if(degree[i]==0) {
                bfsQueue.add(i);
            }
        }

        int visitedNodes = 0;
        while(!bfsQueue.isEmpty()) {
            int popped = bfsQueue.poll();
            visitedNodes++;
            for(int connection: adjList.get(popped)) {
                degree[connection]--;
                if(degree[connection]==0) {
                    bfsQueue.add(connection);
                }
            }
        }
        return visitedNodes==numCourses;
    }
}
