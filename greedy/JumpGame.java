package greedy;

public class JumpGame {
    public static void main(String args[]) {
        System.out.println(canJump(new int[] {2,3,1,1,4}));
    }
    public static boolean canJump(int[] nums) {
        int maxIndexPossible = 0;
        for(int i=0; i<=maxIndexPossible; i++) {
            maxIndexPossible = Math.max(maxIndexPossible, i+nums[i]);
            if(maxIndexPossible>=nums.length-1) {
                return true;
            }
        }
        return false;
    }
}
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Approach:
 * Only need to know if the last index is possible or not.
 * So at any index we check what is the max attainable index.
 * If it ever becomes n or >n, then last index is attainable.
 */
