package greedy;

import recursion.SubsequenceWithKSum;

import java.util.*;

public class FractionalKnapsack {
    public static void main(String args[]) {
        Pair pair1 = new Pair(6, 3);
        Pair pair2 = new Pair(1, 6);
        Pair pair3 = new Pair(5, 1);
        Pair pair4 = new Pair(3, 4);
        Pair[] unsorted = {pair1, pair2, pair3, pair4};
        Arrays.sort(unsorted, new CustomSort());
        for (Pair p : unsorted) {
            System.out.println(p);
        }
    }

    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, new CustomSort());
        int remainingWeight = w;
        double totalValue = 0;
        for (int i = 0; i < n; i++) {
            if (items[i].weight <= remainingWeight) {
                remainingWeight = remainingWeight - items[i].weight;
                totalValue = totalValue + items[i].value;
            } else {
                totalValue = totalValue + (items[i].value * ((double) remainingWeight / items[i].weight));
                break;
            }
        }
        return totalValue;
    }


}

class CustomSort implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        double fraction1 = (double) o1.value / (double) o1.weight;
        double fraction2 = (double) o2.value / (double) o2.weight;
        double diff = (fraction2 - fraction1);
        return diff > 0 ? 1 : -1;
    }
}

class Pair {
    int value;
    int weight;

    Pair(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pair{value=" + value + ", weight=" + weight + '}';
    }
}