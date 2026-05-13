import java.util.ArrayList;
import java.util.List;

public class dt_may_13 {
    public static void main(String[] args) {

    }
    public static int minMoves(int[] nums, int limit) {
        List<Integer> x = new ArrayList<Integer>();

        int l = 0, u = nums.length-1;

        while (l < u){
            if(!x.contains(nums[l] + nums[u])) {
                x.add(nums[l] + nums[u]);
            }
            l++;
            u--;
        }

        for (int i = 0; i < x.size(); i++) {
            int cur = x.get(i);
            l = 0;
            u = nums.length-1;
            int steps = 0;
            while (l < u){
                int curS = nums[l] + nums[u];
                if(curS < cur) {
                    steps++;
                } else if (curS > limit && (nums[l] < limit || nums[u] < limit)) {
                    steps++;
                } else if (curS > limit && (nums[l] >= limit && nums[u] >= limit)) {
                    steps += 2;
                }
                l++;
                u--;
            }
        }

        return 1;
    }
}
