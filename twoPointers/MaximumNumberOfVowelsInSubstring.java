package twoPointers;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowelsInSubstring {
    public static void main(String[] args) {
        System.out.println(maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
    }
    public static int maxVowels(String s, int k) {
        if(s.length()<k)
            return 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int i=0, j=k-1;
        int noOfVowels = 0;
        for(int l=0; l<k; l++) {
            if(vowels.contains(s.charAt(l))) {
                noOfVowels++;
            }
        }
        int maxVowels = noOfVowels;
        while(j+1<s.length()) {
            if(vowels.contains(s.charAt(i))) {
                noOfVowels--;
            }
            i++;
            j++;
            if(vowels.contains(s.charAt(j))) {
                noOfVowels++;
            }
            maxVowels = Math.max(noOfVowels, maxVowels);
        }
        return maxVowels;
    }
}
/**
 * Approach used : Sliding window
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
