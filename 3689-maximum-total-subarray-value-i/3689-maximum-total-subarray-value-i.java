class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            x = Math.min(x, nums[i]);
            y = Math.max(y, nums[i]);
        }

        return (long) (y - x) * k;
    }
}