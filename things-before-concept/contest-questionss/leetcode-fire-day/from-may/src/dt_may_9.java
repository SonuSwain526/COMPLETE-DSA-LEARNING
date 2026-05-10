import java.util.Arrays;

public class dt_may_9 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
                {9,10,11,12},
                {9,10,11,12}
        };

        grid = rotateGrid(grid, 1);
        for(int[] x: grid){
            System.out.println(Arrays.toString(x));
        }
    }
    public static int[][] rotateGrid(int[][] grid, int k) {
        int mid = grid[0].length/2;

        int[][] arr = new int[grid.length][grid[0].length];
        for (int i = 0; i < mid; i++) {
            for (int j = i; j < grid[0].length-i; j++) {
                if(i == j){
                    arr[i+1][j] = grid[i][j];
                }else
                    arr[i][j-1] = grid[i][j];
            }

            for (int j = i; j < grid.length-i; j++) {
                if(j == grid.length -1 - i){
                    arr[j][i+1] = grid[j][i];
                }else
                    arr[j+1][i] = grid[j][i];
            }
            for (int j = i; j < grid[0].length-i; j++) {
                if(j == grid[0].length -1 - i){
                    arr[grid.length -1 - i-1][j] = grid[i][j];
                }else
                    arr[grid.length-1-i][j+1] = grid[grid.length-1-i][j];
            }
            for (int j = i; j < grid.length-i; j++) {
                if(j == i){
                    arr[i][grid[0].length-i-2] = grid[i][grid[0].length-i-1];
                }else
                    arr[j-1][grid[0].length-i-1] = grid[j][grid[0].length-i-1];
            }
//            grid =arr;
        }
        return arr;
    }
}
