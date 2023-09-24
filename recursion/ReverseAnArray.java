package recursion;

public class ReverseAnArray {
    public static void main(String[] args) {
        reverse(new int[] {1,2,3,4,5}, 0);
    }

    private static void reverse(int[] inputArray,int i) {
        if(i >= inputArray.length/2)
            return;
        swap(i, inputArray);
        reverse(inputArray, i++);
    }

    private static void swap(int i, int[] inputArray) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[inputArray.length - i];
        inputArray[inputArray.length - i] = temp;
    }
}

