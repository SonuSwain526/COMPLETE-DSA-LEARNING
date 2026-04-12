import java.util.Arrays;

public class Lc3741med {
    public static void main(String[] args) {
        System.out.println(another(new int[]{1,1,2,3,2,1,2}));
    }
    public static int another(int[] nums){
        Integer[] idx = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            idx[i] = i;
        }
        boolean x = false;
        int min = Integer.MAX_VALUE;
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i < nums.length-2 && nums[i] == nums[i+1] && nums[i] == nums[i+2]){
                min = Math.min(min, (Math.abs(idx[i] - idx[i+1]) + Math.abs(idx[i+1] - idx[i+2]) + Math.abs(idx[i] - idx[i+2])));
                x = true;
            }
        }
        System.out.println(Arrays.toString(idx));
        System.out.println(Arrays.toString(nums));
        if(x) return min;
        else return -1;
    }
    public static int minimumDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int c = 0;
            int[] ar = new int[3];
            ar[0] = i;
            for (int j = i+1; j < nums.length; j++) {
                if(cur == nums[j]){
                    ar[c+1] = j;
                    c++;
                }
                if(c == 2){
                    min = Math.min(min, (Math.abs(ar[0] - ar[1]) + Math.abs(ar[1] - ar[2]) + Math.abs(ar[0] - ar[2])));
                    break;
                }
            }

        }
        return min;
    }
}
