package arraysAndStrings;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int j = height.length-1;
        int maxArea = 0;
        int i = 0;
        while(i<j) {
            int currArea = (j-i)*(Math.min(height[i], height[j]));
            if(maxArea<currArea)
                maxArea = currArea;
            if(height[i]<height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return maxArea;
    }
}
