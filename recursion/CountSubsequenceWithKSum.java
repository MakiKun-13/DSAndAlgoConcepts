package recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSubsequenceWithKSum {
    public static void main(String[] args) {
        System.out.println(countSubsequenceWithKsum(new ArrayList<>(Arrays.asList(1, 2, 1)) , new ArrayList<>(), 0, 0, 2));
    }
    private static int countSubsequenceWithKsum(List<Integer> inputList, List<Integer> currentList,
                                                int i, int currentSum, int targetSum) {
        if(currentSum>targetSum) { //Can only be done if array has only positive integers
            return 0;
        }
        if(i==inputList.size()) {
            if(currentSum == targetSum) {
                return 1;
            }
            return 0;
        }
        currentList.add(inputList.get(i));
        currentSum += inputList.get(i);
        int l = countSubsequenceWithKsum(inputList, currentList, i+1, currentSum, targetSum);
        currentList.remove(currentList.size()-1);
        currentSum -= inputList.get(i);
        int r = countSubsequenceWithKsum(inputList, currentList, i+1, currentSum, targetSum);
        return l+r;
    }
}
/**
 * Time Complexity: 2^n (For every function call we are calling 2 functions so 2*2*2... i.e exponential)
 *
 **/
