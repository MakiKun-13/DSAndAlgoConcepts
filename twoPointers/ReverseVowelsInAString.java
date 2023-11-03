package twoPointers;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsInAString {
    public static void main(String[] args) {
        reverseVowels("leetcode");
    }
    public static String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] word = s.toCharArray();
        int i=0; int j=s.length()-1;
        while(i<j) {
            if(!vowels.contains(word[i]))
                i++;
            if(!vowels.contains(word[j]))
                j--;
            if(vowels.contains(word[i]) && vowels.contains(word[j])) {
                char temp = word[i];
                word[i] = word[j];
                word[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(word);
    }
}
