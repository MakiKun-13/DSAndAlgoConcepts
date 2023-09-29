package recursion;

public class NinjaTraining {
    public static void main(String[] args) {
        System.out.println(ninjaTraining(2, new int[][]{{10, 50, 1}, {5, 100, 11}}));
    }
    public static int ninjaTraining(int n, int points[][]) {
        return calculatePoints(points, n-1, 3);
    }

    public static int calculatePoints(int[][] points, int day, int lastTask) {
        if(day == 0) {
            int max = 0;
            for(int ind=0; ind<3; ind++) {
                if(ind!=lastTask) {
                    max = Math.max(max, points[0][ind]);
                }
            }
            return max;
        }
        int max = 0;
        for(int ind=0; ind<3; ind++) {
            if(ind!=lastTask) {
                int currPoint = points[day][ind] + calculatePoints(points, day-1, ind);
                max = Math.max(max, currPoint);
            }
        }
        return max;
    }
}
/**
 * Recursive solution
 */