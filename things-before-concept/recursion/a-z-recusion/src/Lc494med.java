public class Lc494med {
    public static void main(String[] args) {
        System.out.println(x(new int[]{1,1,1,1,1}, 3, 0, 0,0));
    }
    public static int x(int[] nums, int target, int sum, int ix, int c) {
        if(sum == target && ix == nums.length){
            return c+1;
        } else if (ix >= nums.length) {
            return c;
        }

        int count = c;
        count = x(nums, target, sum + nums[ix], ix+1, count);
        count = x(nums, target, sum - nums[ix], ix+1, count);
        return count;
    }
}
