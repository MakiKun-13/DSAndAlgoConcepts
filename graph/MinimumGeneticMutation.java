package graph;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }
    public static int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(List.of(bank));
        String[] characters = new String[] {"A", "C", "G", "T"};
        Queue<String> bfsQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        bfsQueue.add(startGene);
        levelQueue.add(0);
        Set<String> visited = new HashSet<>();
        while(!bfsQueue.isEmpty()) {
            String polledString = bfsQueue.poll();
            visited.add(polledString);
            int level = levelQueue.poll();
            if(polledString.equals(endGene)) {
                return level;
            }
            level++;
            for(int i=0; i<polledString.length(); i++) {
                for(int j=0; j<characters.length; j++) {
                    StringBuilder builder = new StringBuilder(polledString);
                    String newString = builder.replace(i, i+1, characters[j]).toString();
                    if(!visited.contains(newString) && bankSet.contains(newString)) {
                        bfsQueue.add(newString);
                        levelQueue.add(level);
                    }
                }
            }
        }
        return -1;
    }
}
