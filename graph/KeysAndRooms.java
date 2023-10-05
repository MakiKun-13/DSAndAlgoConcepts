package graph;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(new ArrayList<>(Arrays.asList(new ArrayList<>(List.of(1)),
                new ArrayList<>(List.of(2)), new ArrayList<>(List.of(3)),
                new ArrayList<>()))));
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedSet = new HashSet<>();
        Queue<Integer> bfsQueue = new LinkedList<>();
        for(int i: rooms.get(0)) {
            visitedSet.add(0);
            bfsQueue.add(i);
        }
        while(!bfsQueue.isEmpty()) {
            int element = bfsQueue.poll();
            if(!visitedSet.contains(element)) {
                visitedSet.add(element);
                for(int i: rooms.get(element)) {
                    bfsQueue.add(i);
                }
            }
        }
        return visitedSet.size() == rooms.size();
    }
}
