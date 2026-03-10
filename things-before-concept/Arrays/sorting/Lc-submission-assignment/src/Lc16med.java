import java.util.*;

public class Lc16med {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,1,1,1,2,-1,-3};
//        System.out.println(threeSum(nums));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i<nums.length - 2; i++){
            int s = i + 1, e = nums.length - 1;
            while(s < e){
                int sum = nums[i] + nums[s] + nums[e];
                if(Math.abs(target - sum) < Math.abs(target - result)){
                    result = sum;
                }
                if(sum == target){
                    return result;
                }else if(sum > target){
                    e--;
                }else s++;
            }
        }
        return result;
    }
}
