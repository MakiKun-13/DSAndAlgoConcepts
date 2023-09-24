package recursion;

public class Palindrome {
    public static void main(String[] args) {
        isPalindrome("madam");
    }
    public static boolean isPalindrome(String s) {
        return checkPalindrome(0, s);
    }
    public static boolean checkPalindrome(int i, String str) {
        if(i==str.length()/2) {
            return true;
        }
        if(str.charAt(i) != str.charAt(str.length()-i-1)) {
            return false;
        }
        return checkPalindrome(i+1, str);
    }
}
/**
 * Time complexity: n/2
 * Space complexity: n/2 (due to n/2 functions in the recursion stack)
 */