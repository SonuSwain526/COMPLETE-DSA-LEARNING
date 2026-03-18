import java.util.Arrays;
import java.util.List;

public class MinMasarr {
    public static void main(String[] args) {
        System.out.println(getMinMax(new int[]{2,3,4,5,1}));
    }
    public static List<int[]> getMinMax(int[] arr) {
        // code Here
        return List.of(x(arr, 1, arr.length - 2, arr[0], arr[arr.length - 1]));
    }
    public static int[] x(int[] a, int l, int e, int sm, int lr){
        if(l > e) return new int[]{sm, lr};
        if(Math.max(a[l], a[e]) > lr){
            lr = Math.max(a[l], a[e]);
            l++;
            e--;
            return x(a, l, e, sm , lr);
        }
        if(Math.min(a[l], a[e]) < sm){
            sm = Math.min(a[l], a[e]);
            l++;
            e--;
            return x(a, l, e, sm , lr);
        }
        else {
            l++;
            e--;
            return x(a, l, e, sm, lr);
        }
    }
}
