import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lc3070med {
    public static void main(String[] args) {
        int[][] x = {
                {7,2,9},
                {1,5,0},
                {2,6,6}
        };
        System.out.println(countSubmatrices(x, 18));
    }
    public static int countSubmatrices(int[][] grid, int k) {
        int[][] a = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if(i == 0){
                    sum += grid[i][j];
                    a[i][j] = sum;
                }else {
                    if(j == 0) {
                        sum = grid[i][j] + a[i - 1][j];
                        a[i][j] = sum;
                    }else {
                        sum = a[i][j-1] + a[i - 1][j];
                        a[i][j] = sum - a[i-1][j-1] + grid[i][j];
                    }
                }

            }
        }
        for(int[] x: a){
            System.out.println(Arrays.toString(x));
        }
        int c = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(a[i][j] <= k){
                    c++;
                }else break;
            }
        }
    return c;
    }
}
