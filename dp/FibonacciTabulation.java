package dp;

public class FibonacciDPTabulation {
    public static void main(String args[]) {
        System.out.println(findFibonacci(6));
    }
    public static int findFibonacci(int n) {
        int prev = 1;
        int prev2 = 0;
        for(int i= 2; i<=n; i++) {
            int temp = prev2;
            prev2 =prev;
            prev = temp + prev;
        }
        return prev;
    }
}
/**
 * Solved with Tabulation
 * Time Complexity: O(n)
 * Space complexity: O(1) (Just variables)
 */