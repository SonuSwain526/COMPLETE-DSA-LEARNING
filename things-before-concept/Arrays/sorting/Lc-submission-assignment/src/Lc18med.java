import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc18med {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2};
        System.out.println(fourSum1(nums, 8));

    }
    public static List<List<Integer>> fourSum1(int[] nums, int target) {

        List<List<Integer>> x = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int s = j + 1, e = n-1;
                while (s < e){
                    int sum = nums[i] + nums[j] + nums[s] + nums[e];
                    if(sum == target){
                        x.add(Arrays.asList(nums[i], nums[j], nums[s], nums[e]));
                        break;
                    } else if (sum < target) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }
        return x;
    }
}
