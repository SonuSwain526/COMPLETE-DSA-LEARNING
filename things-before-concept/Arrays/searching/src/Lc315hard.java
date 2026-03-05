import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lc315hard {
    public static void main(String[] args) {
        int[] x = {5,1,2,6,1};
        System.out.println(countSmaller(x));
    }
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> x = new ArrayList<Integer>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return x;
    }
}
