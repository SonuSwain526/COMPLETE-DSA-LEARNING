import java.util.Arrays;

public class TowSum {
    public static void main(String[] args) {
        int[] nums = {1,2,1,4};
        int[] x = new int[2];
        int target = 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i == j){
                    continue;
                }
                if(nums[i] + nums[j] == target){
                    x[0] = j;
                    x[1] = i;
                }
            }
        }
        System.out.println(Arrays.toString(x));
    }
}
