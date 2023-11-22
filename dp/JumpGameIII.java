package dp;

public class JumpGameIII {
    public static void main(String[] args) {
        canReach(new int[] {4,2,3,0,3,1,2}, 5);
    }
    static int[] visited;
    public static boolean canReach(int[] arr, int start) {
        visited = new int[arr.length];
        return findIfCanReach(arr, start);
    }
    public static boolean findIfCanReach(int[] arr, int index) {
        if(arr[index]==0) {
            return true;
        }
        if(visited[index]!=0) {
            return false;
        }
        visited[index] = 1;
        boolean left = false, right = false;
        if(index+arr[index]<arr.length) {
            left = findIfCanReach(arr, index + arr[index]);
        }
        if(index-arr[index]>=0) {
            right = findIfCanReach(arr, index-arr[index]);
        }
        return (left || right);
    }
}
