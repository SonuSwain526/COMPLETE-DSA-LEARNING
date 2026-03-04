import java.util.ArrayList;
import java.util.Arrays;

public class Lc1539esey {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5));
    }
    public static int findKthPositive(int[] arr, int k) {
        int ix = 0;
        int i = 1;
        while (ix <= k){
            if(bs(arr, i)){
                ix++;
            }
            i++;
        }
        return i;
    }
    public static boolean bs(int[] a, int t){
        int s = 0, e = a.length-1;
        while (s <= e){
            int mid = s + (e - s)/2;
            if (a[mid] <= t) {
                s = mid+1;
            }else e = mid;
        }
        return true;
    }
}
