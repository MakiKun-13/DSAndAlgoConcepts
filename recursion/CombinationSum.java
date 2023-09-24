package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {2,3,5}, 8).toString());
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        findCombinationSum(0, candidates, new ArrayList<>(), target, resultList);
        return resultList;
    }
    public static void findCombinationSum(int i, int[] candidates, List<Integer> currentList, int target, List<List<Integer>> resultList) {
        if(target==0) {
            resultList.add(List.copyOf(currentList));
            return;
        }
        if(target<0) {
            return;
        }
        if(i>=candidates.length) {
            return;
        }
        currentList.add(candidates[i]);
        findCombinationSum(i, candidates, currentList, target - candidates[i], resultList);
        currentList.remove(currentList.size()-1);
        findCombinationSum(i+1, candidates, currentList, target + candidates[i], resultList);
    }
}
