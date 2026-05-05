import java.lang.reflect.Array;
import java.util.Arrays;

public class dt_may_5 {
    public static void main(String[] args) {
        int[][] m = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(m);
    }
    public static void rotate(int[][] matrix) {
        int l = 0, r = matrix.length-1, t = 0, d = matrix.length-1;
        int [][]x = new int[matrix.length][matrix.length];
        while (l <= r && t <= d){
            int a = r;
            for (int i = l; i <= r; i++) {
//                x[t][i] = matrix[i][l];
//                x[t][i] = matrix[l][a];
                x[i][r] = matrix[t][i];
                a--;
            }
            int j = d;
            for (int i = t; i <= d; i++) {
                x[t][i] = matrix[j][l];
                x[d][j] = matrix[i][r];
                x[l][j] = matrix[d][j];
                j--;
            }
            l++;
            r--;
            t++;
            d--;
        }

        for(int[] xx: x){
            System.out.println(Arrays.toString(xx));
        }
    }
}
