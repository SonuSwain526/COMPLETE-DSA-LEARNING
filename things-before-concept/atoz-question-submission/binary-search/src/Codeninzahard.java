import java.util.Arrays;
import java.util.OptionalInt;

public class Codeninzahard {
    public static void main(String[] args) {
        int[] x = {6,4,0,3,4,7,10,9};
        System.out.println(aggressiveCows(x, 4));
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int s = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x: stalls){
            s = Math.min(s, x);
            max = Math.max(max, x);
        }
        int e = max - s;
        while (s <= e){
            int mid = s + (e - s)/2;
            if(isValid(stalls, k, mid)){
                s = mid+1;
            }else e = mid - 1;
        }
        return e;
    }
    public static boolean isValid(int[] x, int k, int mid){
        int i = 1;
        int currIx = x[0];
        for (int j = 1; j < x.length; j++) {
            if(mid <= x[j] - currIx){
                currIx = x[j];
                i++;
            }if(i >= k){
                return true;
            }
        }
        return false;
    }
}
