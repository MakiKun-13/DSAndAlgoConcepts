package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        findNthFibonacci(6);
    }
    public static int findNthFibonacci(int n) {
        if(n <=1 ) {
            return n;
        }
        return findNthFibonacci(n-2) + findNthFibonacci(n-1);
    }
}
/**
 * Time Complexity: 2^n (For every function call we are calling 2 functions so 2*2*2... i.e exponential)
 * Space Complexity: n
 **/