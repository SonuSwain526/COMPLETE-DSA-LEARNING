import java.util.ArrayList;
import java.util.Arrays;

public class Sprialmax2 {
    public static void main(String[] args) {
        int[][] x = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int input = 3;
        spiralPrint(x, input);
    }
    static void spiralPrint(int[][] arr, int n){
        int[][] x = new int[n][n];
        int count = 0;
        int top = 0, buttom = n-1, left = 0, right = n-1;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                x[i][j] = 0;
//            }
//        }
        while (top<=buttom && left <= right){

            for (int j = left; j <= right; j++) {
                x[top][j] = count+1;
                count++;
            }
            top++;

            for (int i = top; i <= buttom; i++) {
                x[i][right] = count+1;
                count++;
            }
            right--;

            if(buttom >= top){
                for (int i = right; i >= left; i--) {
                    x[buttom][i] = count+1;
                    count++;
                }
                buttom--;
            }
            if(right >= left){
                for (int j = buttom; j >= top; j--) {
                    x[j][left] = count+1;
                    count++;
                }
                left++;
            }
        }

        for(int[] a: x){
            System.out.println(Arrays.toString(a));
        }
    }
}
