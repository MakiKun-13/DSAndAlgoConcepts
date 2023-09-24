package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequenceWithKSum {
    static List<List<Integer>> resultList = new ArrayList<>();
    public static void main(String[] args) {
        subsequenceWithKsum(new ArrayList<>(Arrays.asList(10,1,2,7,6,5)) , new ArrayList<>(), 0, 0, 8);
        System.out.println(resultList.toString());
    }

    private static void subsequenceWithKsum(List<Integer> inputList, List<Integer> currentList,
                                            int i, int currentSum, int targetSum) {
        if(currentSum>targetSum || i==inputList.size()) {
            if(currentSum == targetSum) {
                resultList.add(List.copyOf(currentList));
            }
            return;
        }
        currentList.add(inputList.get(i));
        currentSum += inputList.get(i);
        subsequenceWithKsum(inputList, currentList, i+1, currentSum, targetSum);
        currentList.remove(currentList.size()-1);
        currentSum -= inputList.get(i);
        subsequenceWithKsum(inputList, currentList, i+1, currentSum, targetSum);
    }
}
/**
 * Time Complexity: 2^n (For every function call we are calling 2 functions so 2*2*2... i.e exponential)
 *
 **/
