import java.util.Arrays;

public class Lc41hard {
    public static void main(String[] args) {
        int[] x = {-3,9,16,4,5,16,-4,9,26,2,1,19,-1,25,7,22,2,-7,14,2,5,-6,1,17,3,24,-4,17,15};
        System.out.println(firstMissingPositive(x));

    }
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        boolean check = true;
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] > 0){
                if(nums[i] != 1 && check){
                    return 1;
                }
                check = false;
                if(nums[i+1] - nums[i] != 1 ){
                    return nums[i]+1;
                }
            }
            if(i == nums.length-2){return nums[i+1] + 1;}
        }
        return -1;
    }
}
