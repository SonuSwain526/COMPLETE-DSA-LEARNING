class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int sum = 0;
            while (cur > 0) {
                sum += cur % 10;
                cur = cur / 10;
            }
            if (sum == i) return i;
        }
        return -1;
    }
}