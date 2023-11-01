package binarySearch;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        successfulPairs(new int[] {5,1,3}, new int[] {1,2,3,4,5}, 7);
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++) {
            spells[i] = findPair(spells[i], potions, success);
        }
        return spells;
    }
    public static int findPair(int spell, int[] potions, long success) {
        int low = 0;
        int high = potions.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(low==high) {
                if((long)spell*(long)potions[mid] < success) {
                    return potions.length - mid -1;
                }
                else {
                    return potions.length - mid;
                }
            }
            else {
                if((long)potions[mid]*(long)spell<success) {
                    low = mid+1;
                }
                else {
                    high = mid;
                }
            }
        }
        return 0;
    }
}
