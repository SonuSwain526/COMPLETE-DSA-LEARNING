import java.util.Arrays;

public class Setmax0 {
    public static void main(String[] args) {
        int[][] arr = {{0,1}};
        int[][] ans = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, ans[i], 0, arr[0].length);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0){
                    set0(arr, i, j, ans);
                }
            }
        }
        for (int[] ints : ans) {
            System.out.println(Arrays.toString(ints));
        }
    }
    static void set0(int[][] x,int i,int j, int[][] ans){
        int a = i, b = 0, c = j, d = 0;
        while (a >= 0){
            ans[a][j] = 0;
            a--;
        }
        while (b < x.length){
            ans[b][j] = 0;
            b++;
        }
        while (c >= 0){
            ans[i][c] = 0;
            c--;
        }
        while (d < x[0].length) {
            ans[i][d] = 0;
            d++;
        }
    }
}
