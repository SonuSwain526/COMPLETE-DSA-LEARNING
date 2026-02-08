import java.util.Arrays;

class Sum1darr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(arr)));
    }
    public static int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        for(int i = 0; i < sum.length; i++){
            if(i == 0){
                sum[i] = nums[i];
            }
            else
                sum[i] = sum[i-1] + nums[i];
        }
        return sum;
    }
}