import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dt_may_11 {
    public static void main(String[] args) {
        int[] a = {10,11,12};
        System.out.println(Arrays.toString(separateDigits(a)));
    }
    public static int[] separateDigits(int[] nums) {
        int s = 0;
        for (int num : nums) {
            int cur = (int) Math.log10(num) + 1;
            s += cur;
        }
        int[] x = new int[s];
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            int t = nums[i];
            List<Integer> xx = new ArrayList<Integer>();
            while(t > 0){
                xx.add(t % 10);
                t = t/10;
            }
            for(int k = xx.size()-1; k>=0; k--){
                x[j] = xx.get(k);
                j++;
            }
        }
        return x;
    }
}
