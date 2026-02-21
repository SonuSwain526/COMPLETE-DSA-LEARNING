import java.util.Arrays;

public class ProductExceptitself {
    public static void main(String[] args) {
        int[] nums = {-1,0,0,-1};
        int[] ans = new int[nums.length];
        int mul = 1;
        for (int num : nums) {
            mul *= num;
        }
        for (int i = 0; i < nums.length; i++) {
            int x = 1;
            if(nums[i] == 0){
                nums[i] = 1;
                for (int num : nums) {
                    x *= num;
                }
                ans[i] = x;
            }
            else
                ans[i] = mul/nums[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}
