package twoPointers;

public class RemoveDuplicatesFromAnArrayII {
    public static void main(String[] args) {
        removeDuplicates(new int[] {1,1,1,2,2,3});
    }
    public static int removeDuplicates(int[] nums) {
        int left=0, right=1, count=1;
        while(right<nums.length) {
            if(nums[left]==nums[right]) {
                count++;
            }
            else {
                count = 1;
            }
            if(count<=2) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
    }
}
/**
 The 'left' pointer maintains where the new element is to be added.
 The 'right' pointer is used to traverse the array
 */