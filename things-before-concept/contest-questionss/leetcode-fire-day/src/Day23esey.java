public class Day23esey {
    public static void main(String[] args) {

    }
    public static int getMinDistance(int[] nums, int target, int start) {
        if(nums[start] == target) return 0;
        int len = Integer.MAX_VALUE;
        for (int i = start; i < nums.length; i++) {
            if(nums[i] == target) {
                len = Math.abs(i - target);
                break;
            }
        }
        for (int i = start; i >= 0 ; i--) {
            if(nums[i] == target){
                len = Math.min(len,Math.abs(i - target));
            }
        }
        return len;
    }
}
