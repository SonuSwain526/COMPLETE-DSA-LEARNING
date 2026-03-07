import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] x = {2,1,5,4,3};
        int[] y = {};
        cyclicSort(x);
    }
    static void cyclicSort(int[] x){
        int curelem = 1;
        int ix = 0;
        while (ix < x.length){
            if(ix+1 != x[ix]){
                int temp = x[ix];
                x[ix] = x[ix+1];
                x[ix+1] = temp;
            }
            ix++;
        }
        System.out.println(Arrays.toString(x));
    }
}
