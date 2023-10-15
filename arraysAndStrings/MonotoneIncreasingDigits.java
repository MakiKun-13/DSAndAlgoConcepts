package arraysAndStrings;

/**
 * Monotone Increasing Digits
 */
public class MonotoneIncreasingDigits {
    public static void main(String args[]) {
        int n= 133442;
        System.out.println(monotoneIncreasingDigits(n));
    }
    public static int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int index = -1;
        for(int i=1; i<digits.length; i++) {
            if(digits[i]<digits[i-1]) {
                digits[i-1] = (char)(digits[i-1] - 1);
                index = i;
            }
        }
        if(index==-1)
            return n;
        for(int i=index; i<digits.length; i++) {
            digits[i] = '9';
        }
        return Integer.parseInt(String.valueOf(digits));
    }
}
