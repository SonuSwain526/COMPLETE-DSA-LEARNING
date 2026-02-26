import java.util.ArrayList;
import java.util.Arrays;

public class FstndLastixoftarget {
    public static void main(String[] args) {
        int[] x = {1,2,2,3,3};
        int[] y = {-1,-1};
        int target = 4;
        int left = xy(x,target,true);
        int right = xy(x, target, false);
        y[0] = left;
        y[1] = right;
        System.out.println(Arrays.toString(y));
    }
    public static int xy(int[] x, int target, boolean isLeft){
        int start = 0;
        int end = x.length-1;
        int idx = -1;
        while (start<=end){
            int mid = (start+end)/2;
            if(x[mid] == target){
                idx = mid;
                if(isLeft){
                    end = mid -1;
                }
                else
                    start = mid+1;
            }
            else if (x[mid] < target){
                start = mid+1;
            }
            else
                end = mid - 1;
        }
        return idx;
    }
}
