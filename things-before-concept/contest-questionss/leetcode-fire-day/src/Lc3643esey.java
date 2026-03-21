import java.util.Arrays;

public class Lc3643esey {
    public static void main(String[] args) {
        int[][] x= {
                {3,4,2,3},
                {2,3,4,2}
        };
        for(int[] a: reverseSubmatrix(x, 0,2,2)){
            System.out.println(Arrays.toString(a));
        }
    }
    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = y; i < k+y; i++) {
            int j = x;
            int l = k+x-1;
            while (j < l){
                int temp = grid[j][i];
                grid[j][i] = grid[l][i];
                grid[l][i] = temp;
                j++;
                l--;
            }
        }
        return grid;
    }
}
