class Solution {
    public boolean canJump(int[] nums) {
        if (nums[0] == 0) return nums.length == 1;

        return helper (nums, 0);
    }

    boolean helper (int[] nums, int i){

        if (i >= nums.length-1) return true;
        if (nums[i] == 0) return false;
        if (nums[i] + i + 1 >= nums.length) return true;

        int maxIx = 0, max = 0;

        for (int j = i+1; j <= i + nums[i] && j < nums.length; j++){
            if (max < j + nums[j]) {
                max = j + nums[j];
                maxIx = j;
            }
            // max = Math.max(max, nums[j]);
        }

        return helper(nums, maxIx);
    }
}