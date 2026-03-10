import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoursumWithDistinct {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,1,1,1,2,-1,-3};
        System.out.println(fourSum(nums, 2));

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> x = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                if(nums[i] != nums[j]) {
                    int s = j + 1, e = n-1;
                    while (s < e){
                        if((nums[s] != nums[j] && nums[e] != nums[j]) && (nums[s] != nums[e])){
                            x.add(Arrays.asList(nums[i], nums[j], nums[s], nums[e]));
                            s++;
                            e--;
                        } else if ((nums[s] == nums[e])) {
                            s++;
                            e--;
                        } else if(nums[s] == nums[j]){
                            s++;
                        } else if (nums[e] == nums[j]) {
                            e--;
                        }
                    }
                }
            }
        }
        return x;
    }
}
