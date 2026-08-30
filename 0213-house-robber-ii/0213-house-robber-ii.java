class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int temp = nums[0];
        nums[0] = 0;
        int x = dphelper(nums, 0, dp);
        nums[0] = temp;
        Arrays.fill(dp, -1);
        nums[nums.length - 1] = 0;
        return Math.max(x, dphelper(nums, 0, dp));
    }
    int dphelper(int[] nums, int i, int[] dp) {
        if (i >= nums.length) return 0;
        // if (b && i == nums.length - 1) return 0;
        if (dp[i] != -1) return dp[i];

        int x = nums[i] + dphelper(nums, i + 2, dp);
        int y = dphelper(nums, i + 1, dp);

        return dp[i] = Math.max(x, y);
    }
}