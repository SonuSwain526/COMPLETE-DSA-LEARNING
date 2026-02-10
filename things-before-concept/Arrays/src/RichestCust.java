import java.util.Arrays;

public class RichestCust {
    public static void main(String[] args) {
        int[][] arr = {{1,5,3},
                        {1,3,3},
                        {12,3,4}};
        int max = 0;
        for (int[] ints : arr) {
            int curSum = 0;
            for (int j = 0; j < 3; j++) {
                curSum = curSum + ints[j];
            }
            if (curSum > max) {
                max = curSum;
            }

        }
        System.out.println(max);

    }
}
