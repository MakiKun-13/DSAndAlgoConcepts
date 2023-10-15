package arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KSubArrays {
    public static void main(String args[]) {
        System.out.println(kSub(15, new ArrayList<>(List.of(45, 15, 7, 8, 10))));
    }
    static long count = 0;
    static List<List<Integer>> combinations = new ArrayList<>();
    public static long kSub(int k, List<Integer> nums) {
        findCount(new ArrayList<>(), 0, 0 , k, nums);
        return count;
    }


    private static void findCount(List<Integer> subArray, int index, int currSum, int k, List<Integer> nums) {
        if(index==nums.size()) {
            List<Integer> clonedList = new ArrayList<>(subArray);
            Collections.sort(clonedList);
            if(currSum!=0 && currSum%k==0 && !combinations.contains(clonedList)) {
                combinations.add(clonedList);
                System.out.println(subArray);
                count++;
            }
            return;
        }
        currSum = currSum + nums.get(index);
        subArray.add(nums.get(index));
        findCount(subArray, index+1, currSum, k,nums);
        currSum = currSum - nums.get(index);
        subArray.remove(subArray.size()-1);
        findCount(subArray, index+1, currSum, k,nums);
    }
}
