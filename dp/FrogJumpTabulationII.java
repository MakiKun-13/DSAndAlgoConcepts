package dp;

public class FrogJumpTabulationII {
    public static void main(String args[]) {
        System.out.println(frogJump(4, new int[] {10, 20, 30, 10}));
    }

    public static int frogJump(int n, int heights[]) {
        return findMinEnergy(n-1, heights);
    }

    public static int findMinEnergy(int n, int[] heights) {
        int prev2 = 0;
        int prev = Math.abs(heights[0]-heights[1]);
        for(int i=2; i<=n; i++) {
            int firstCase = prev + Math.abs(heights[i] - heights[i-1]);
            int secondCase = Integer.MAX_VALUE;
            if(i>1)
                secondCase = prev2 + Math.abs(heights[i] - heights[i-2]);
            prev2=prev;
            prev =  Math.min(firstCase, secondCase);
        }
        return prev;
    }
}
/**
 * Tabulation solution without the array dp[]
 *Time Complexity: O(n)
 *Space Complexity: O(1)
 */
