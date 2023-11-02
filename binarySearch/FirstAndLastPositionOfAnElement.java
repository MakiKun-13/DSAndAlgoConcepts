package binarySearch;

public class FirstAndLastPositionOfAnElement {
    public static void main(String[] args) {
        searchRange(new int[] {5,7,7,8,8,10}, 8);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        //Looping to find the left
        int low=0;
        int high=nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) {
                result[0] = mid;
                high = mid-1;
            }
            else if(nums[mid]<target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        //Looping to find the right
        low=0;
        high=nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) {
                result[1] = mid;
                low = mid+1;
            }
            else if(nums[mid]<target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return result;
    }
}
/**
 * Assumption: Array input is sorted
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */