import java.util.Arrays;

public class Lc2916 {
    public static void main(String[] args) {
        int[][] x = {{12345}, {2},{1}};
        for(int[] i: constructProductMatrix(x)){
            System.out.println(Arrays.toString(i));
        }
    }
    public static int[][] constructProductMatrix(int[][] grid) {
//        int[][] y = new int[grid.length][grid[0].length];
//        int[][] x = new int[grid.length][grid[0].length];
//        int[][] ans = new int[grid.length][grid[0].length];
//
//        int mul = 1;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                int k = 0;
//                while (k < grid[i].length){
//                    if(j != k){
//                        mul = (mul % 12345) * grid[i][k];
//                    }
//                    k++;
//                }
//                x[i][j] = mul;
//                mul = 1;
//            }
//            mul = 1;
//        }
//
//        mul = 1;
//        for (int i = 0; i < grid[0].length; i++) {
//            for (int j = 0; j < grid.length; j++) {
//                int k = 0;
//                while (k < grid.length){
//                    if(j != k){
//                        mul = (mul % 12345) * grid[k][i];
//                    }
//                    k++;
//                }
//                y[j][i] = mul;
//                mul = 1;
//            }
//            mul = 1;
//        }
//
//        mul = 1;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                int k = 0;
//                while (k < grid.length){
//                    mul = (mul % 12345) * x[k][j];
//                    k++;
//                }
//                ans[i][j] = mul * y[i][j] % 12345;
//                mul = 1;
//            }
//        }
//        return ans;
        int n = grid.length * grid[0].length;

        int[] s = new int[n];
        int[] p = new int[n];
        int[] f = new int[n];
        int ix = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                f[ix] = grid[i][j] % 12345;
                ix++;
            }
        }
        p[0] = 1; s[n-1] = 1;
        for(int i = 1; i< n; i++){
            p[i] = (p[i-1] * f[i-1]) % 12345;
        }
        for(int i = n-2; i>= 0; i--){
            s[i] = (s[i+1] * f[i+1]) % 12345;
        }


        //  for(int i = 0; i< n; i++){
        //     f[i] = (p[i] * s[i]) % 12345;
        // }

        ix = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j] = (p[ix] * s[ix]) % 12345;
                ix++;
            }
        }
        return grid;
    }
}
