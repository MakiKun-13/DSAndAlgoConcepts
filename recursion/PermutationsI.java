package recursion;

import java.util.ArrayList;
import java.util.List;

class PermutationsI {
    public static void main(String[] args) {
        System.out.println(permute(new int[] {1,2,3}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        findPermutations(nums, new ArrayList<>(), new ArrayList<>(), resultList);
        return resultList;
    }
    public static void findPermutations(int[] nums, List<Integer> setOfIndices, List<Integer> currentList, List<List<Integer>> resultList) {
        for(int i=0; i<nums.length; i++) {
            if(currentList.size() == nums.length) {
                resultList.add(new ArrayList<>(currentList));
                return;
            }
            if(!setOfIndices.contains(i)) {
                setOfIndices.add(i);
                currentList.add(nums[i]);
                findPermutations(nums, setOfIndices, currentList, resultList);
                currentList.remove(currentList.size() -1);
                setOfIndices.remove(setOfIndices.size() -1);
            }
        }
    }
}
/**
 * This is approach 1:
 * Time complexity: n! * n (n! permutations and looping n times at every level)
 * Space Complexity: n + n (setOfIndices + currentList)
 *
 */
