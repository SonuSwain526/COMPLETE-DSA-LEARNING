class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int x : nums){
            max = Math.max(max, x);
        }
        long total = (long) n * (n + 1) / 2;

        return total - count(nums, k-1, max);
    }
    public long count(int[] a, int k, int max){
        if (k < 0) return 0;

        int left = 0;
        int right = 0; 
        int c = 0; 
        long sum = 0;

        while (right < a.length){
            if (a[right] == max) c++;

            while (c > k){
                if (a[left] == max) c--;
                left++;
            }

            sum += (long) right - left + 1;
            right++;
        }

        return sum;
    }
}