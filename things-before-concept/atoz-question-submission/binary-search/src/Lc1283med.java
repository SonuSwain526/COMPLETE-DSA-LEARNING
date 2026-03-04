import java.util.Arrays;

public class Lc1283med {
    public static void main(String[] args) {
        int[] x = {1,2,5,9,9,2};
        System.out.println(smallestDivisor(x, 7));
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int s = Integer.MAX_VALUE, e = Integer.MIN_VALUE;
        for(int x : nums){
            s = Math.min(s, x);
            e = Math.max(e, x);
        }
        System.out.println(e);
        System.out.println(s);
        while (s<e){
            int mid = (s+e)/2;
            int curTh = 0;
            for(int x: nums){
                curTh += (int) Math.ceil( (double) x /mid);
            }
            if(curTh > threshold){
                s = mid+1;
            }else
                e = mid;
        }
        return s;
    }
}
