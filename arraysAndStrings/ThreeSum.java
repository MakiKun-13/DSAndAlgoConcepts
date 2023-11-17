package arraysAndStrings;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum==0) {
                    result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                }
                else if(sum<0) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return new ArrayList<> (result);
    }
}
