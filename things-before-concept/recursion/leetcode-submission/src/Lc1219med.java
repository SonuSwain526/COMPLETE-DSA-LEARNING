import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc1219med {
    static int e = 0;
    public static void main(String[] args) {
        int[][] g = {
                {0,6,0},
                {5,8,7},
                {0,9,0}
        };
        List<Integer> l = new ArrayList<>();
        boolean[][] b = new boolean[3][3];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if(g[i][j] != 0)
                    x(0, g, i,j,b);
            }
        }
        System.out.println(e);
    }
//    public static int getMaximumGold(int[][] grid) {
//
//    }
    public static void x(int sum, int[][] g, int i, int j, boolean[][] b){
//        if (
//                (i - 1 < 0 || (b[i-1][j] || g[i-1][j] == 0)) &&   // up
//                        (i + 1 >= g.length || (b[i+1][j] || g[i+1][j] == 0)) &&  // down
//                        (j - 1 < 0 || (b[i][j-1] || g[i][j-1] == 0)) &&   // left
//                        (j + 1 >= g[0].length || (b[i][j+1] || g[i][j+1] == 0))     // right
//        ) {
//            // all valid neighbors satisfy condition
//            l.add(sum);
//            return;
//        }
        sum += sum + g[i][j];
        e = Math.max(e, sum);
        int k = i; int m = j;
            b[k][m] = true;
            if(k+1 < g.length && g[k+1][m] != 0 && !b[k+1][m]){
                x(sum, g, k+1, m, b);
            }
            if(k-1 >= 0 && g[k-1][m] != 0 && !b[k-1][m]){
                x(sum, g, k-1, m, b);
            }
            if(m+1 < g[0].length  && g[k][m+1] != 0 && !b[k][m+1]){
                x(sum, g,k, m+1, b);
            }
            if(m-1 >= 0 && g[k][m-1] != 0 && !b[k][m-1]){
                x(sum, g, k, m-1, b);
            }
            b[k][m] = false;

    }
}
