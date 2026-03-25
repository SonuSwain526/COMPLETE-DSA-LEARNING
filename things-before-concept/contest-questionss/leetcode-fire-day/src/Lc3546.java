import java.util.ArrayList;
import java.util.Arrays;

public class Lc3546 {
    public static void main(String[] args) {
        System.out.println(canPartitionGrid(new int[][]{{9753,4621,3652}, {3003,4050,433}}));
    }
    public static boolean canPartitionGrid(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] f = new int[m*n];
        int[] ps = new int[m*n];
        int[] ss = new int[m*n];
        int[] pps = new int[m*n];
        int[] sss = new int[m*n];
        int[] ans = new int[m*n];
        int ix = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                f[ix] = ints[j];
                ix++;
            }
        }
        System.out.println(Arrays.toString(f));
        ix = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[ix] = grid[j][i];
                ix++;
            }
        }
//
        ps[0] = 0;
        int sum = 0;
        int ssum = 0;
        for (int i = 1; i < f.length; i++) {
            sum += f[i-1];
            ssum += ans[i-1];
            pps[i] = ssum;
            ps[i] = sum;
        }
        ss[ss.length-1] = 0;
        sum = 0; ssum = 0;
        for (int i = ss.length-2; i >= 0; i--) {
            sum += f[i+1];
            ssum += ans[i+1];
            sss[i] = ssum;
            ss[i] = sum;
        }
        System.out.println(Arrays.toString(ps));
        System.out.println(Arrays.toString(ss));
        System.out.println(Arrays.toString(pps));
        System.out.println(Arrays.toString(sss));

//        for (int i = 0; i < f.length; i++) {
//            ans[i] = ps[i] + ss[i];
//        }

        for (int i = 1; i < n*m-1; i++) {
            if(ps[i] == ss[i-1]) return true;
        }
        for (int i = 1; i < n*m-1; i++) {
            if(pps[i] == sss[i-1]) return true;
        }


//        ix = 1;int ls = 0, rs = 0;int lls = 0, rrs= 0;
//        while (ix < n*m){
//            for (int i = 0; i < ix; i++) {
//                ls += f[i];
//                lls += ans[i];
//            }
//            for (int i = ix; i < n*m; i++) {
//                rs += f[i];
//                rrs += ans[i];
//            }
//            if(ls == rs || lls == rrs) return true;
//            ix++;
//            ls = 1; rs = 1;
//            lls= 1; rrs = 1;
//        }
        return false;
    }
}
