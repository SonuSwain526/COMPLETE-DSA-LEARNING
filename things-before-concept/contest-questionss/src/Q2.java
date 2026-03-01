import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[] arr = {2,1,3};
        int[] y = x(arr);
        for (int j : y) {
            System.out.print(j + " ");
        }
    }
    public static int[] x(int[] a){
        int[] y = new int[a.length];
        int i = 0, j = a.length-1;
        while (i<=j){
            y[i] = a[j];
            y[j] = a[i];
            i++;
            j--;
        }
        return y;
    }
}
