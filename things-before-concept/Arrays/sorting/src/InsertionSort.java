import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] x = {1,32,-10,0,100000};
        int[] y = {};
        inserSort(x);
    }
    static void inserSort(int[] x){
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(x[j - 1] > x[j]){
                    int temp = x[j-1];
                    x[j-1] = x[j];
                    x[j] = temp;
                }else break;
            }
        }
        System.out.println(Arrays.toString(x));
    }
}
