package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SubsetSumI {
    public static void main(String[] args) {
        System.out.println(subsetSums(new ArrayList<>(Arrays.asList(2,3)), 2));
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        List<Integer> listOfSums = new ArrayList<>();
        listOfSums.add(0);
        findSubsetSums(arr, new ArrayList<>(), 0, listOfSums, 0);
        Collections.sort(listOfSums);
        return new ArrayList<>(listOfSums);
    }
    static void findSubsetSums(ArrayList<Integer> arr, List<Integer> currentList,
                               int i, List<Integer> listOfSums, int currentSum) {
        if(i == arr.size()) {
            return;
        }
        currentList.add(arr.get(i));
        currentSum += arr.get(i);
        listOfSums.add(currentSum);
        findSubsetSums(arr, currentList, i+1, listOfSums, currentSum);
        currentSum -= arr.get(i);
        currentList.remove(currentList.size()-1);
        findSubsetSums(arr, currentList, i+1, listOfSums, currentSum);
    }
}
/**
 * Time complexity: 2^n + 2^nlog(2^n)    (There are 2^n elements in result array that we need to sort)
 * Space complexity: 2^n
 */