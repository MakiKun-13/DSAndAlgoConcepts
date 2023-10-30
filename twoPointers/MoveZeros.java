package twoPointers;

public class MoveZeros {
    public static void main(String[] args) {
        moveZeroes(new int[] {0,1,0,3,12});
    }
    public static void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        while(j<nums.length-1) {
            if(j==0) {
                j++;
            }
            else {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            }
        }
    }
}
