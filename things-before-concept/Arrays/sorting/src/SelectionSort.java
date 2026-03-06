import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] x = {1,32,-10,0,100000};
        int[] y = {};
        SelectSort(x);
    }
    static void SelectSort(int[] x){
        for (int i = 0; i < x.length - 1; i++) {
            int larelem = largElem(x,i);
            int temp = x[i];
            x[i] = x[larelem];
            x[larelem] = temp;
        }
        System.out.println(Arrays.toString(x));
    }
    static int largElem(int[] x, int i){
        int curLarge = i;
        for (int k = i; k < x.length; k++) {
            if(x[curLarge] < x[k]){
                curLarge = k;
            }

        }
        return curLarge;
    }
}
