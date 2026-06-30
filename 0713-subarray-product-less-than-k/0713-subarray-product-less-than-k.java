class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) return 0;
        int left = 0; 
        int right = 0; 
        int c = 1;
        int sum = 0;

        while (right < n){
            c *= nums[right];

            while ( c >= k && left <= right){
                c = c / nums[left];
                left++;
            }

            sum += right - left + 1;
            right++;
        }

        return sum;
    }
}