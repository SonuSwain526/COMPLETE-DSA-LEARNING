class Solution {
    int path = 0;
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        // if (nums[0] == 0) {
        //     if (nums.length == 1) return 0;
        //     // return nums.length == 1;
        // }
        helper(nums, 0);
        return path;
    }
    
    void helper (int[] nums, int i){

        path++;

        if (i >= nums.length-1) return;
        // if (nums[i] == 0) return false;
        if (nums[i] + i + 1 >= nums.length) return;

        int maxIx = 0, max = 0;

        for (int j = i+1; j <= i + nums[i] && j < nums.length; j++){
            if (max < j + nums[j]) {
                max = j + nums[j];
                maxIx = j;
            }
            // max = Math.max(max, nums[j]);
        }

        helper(nums, maxIx);
    }
}