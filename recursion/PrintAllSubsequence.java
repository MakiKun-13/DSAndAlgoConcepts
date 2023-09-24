package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllSubsequence {
    public static void main(String[] args) {
        findSubsequences(new ArrayList<>(), new ArrayList<>(Arrays.asList(3,1,2)), 0);
    }
    public static void findSubsequences(List<Integer> list, List<Integer> input, int i) {
        if(i == input.size()) {
            System.out.println(list.toString());
            return;
        }
        list.add(input.get(i));
        findSubsequences(list, input, i+1);
        list.remove(input.get(i));
        findSubsequences(list, input, i+1);
    }
}