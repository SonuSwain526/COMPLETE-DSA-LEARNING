class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        int n  = nums.length;
        return clcSubArr(nums, k) - clcSubArr(nums, k-1);
    }


    public int clcSubArr(int[] a, int k){
        if ( k < 0) return 0;
        int left = 0; 
        int right = 0;
        int sum = 0; 
        int cur = 0;

        while (right < a.length) {
            cur += a[right];

            while ( cur > k){
                cur -= a[left];
                left++;
            }

            sum += right - left + 1;
            right++;
        }

        return sum;
    }
}