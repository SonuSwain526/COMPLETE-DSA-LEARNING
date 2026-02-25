import java.util.ArrayList;

public class MaxvalofEq {
    public static void main(String[] args) {
        int[][] points = {{-19,9}, {-15,-19}, {-5,-8}};
        int k = 10;
        int max = Integer.MIN_VALUE;
//        ArrayList<Integer> arr = findPoints(points, k);
//        System.out.println(arr);
//        for (int i = 0; i < arr.size(); i = i+2) {
//            max =Math.max(max, points[arr.get(i)][1] + points[arr.get(i+1)][1] + Math.abs(points[arr.get(i)][0] - points[arr.get(i+1)][0]));
//        }
        System.out.println(findPoints(points, k, max));

    }

    public  static int findPoints(int[][] points, int k, int max){
        ArrayList<Integer> x = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[j][0] - points[i][0] > k)
                    break;
                max = Math.max(max,
                        points[i][1] + points[j][1] +
                                (points[j][0] - points[i][0]));
            }
        }
        return max;
    }
}
