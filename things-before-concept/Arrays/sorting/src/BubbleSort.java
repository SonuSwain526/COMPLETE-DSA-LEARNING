import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] x = {0,0,0,100000};
        sort(x);
    }
    static void sort(int[] x){
        for (int i = 0; i < x.length - 1; i++) {
            boolean s = false;
            for (int j = 1; j < x.length - i; j++) {
                if(x[j] > x[j - 1]){
                    int temp = x[j];
                    x[j] = x[j-1];
                    x[j-1] = temp;
                    s = true;
                }
            }
            if(!s){
                break;
            }
        }
        System.out.println(Arrays.toString(x));
    }
}
