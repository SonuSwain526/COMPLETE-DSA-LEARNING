class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        return count(nums, k) - count(nums, k-1);
    }

    public int count(int[] a, int k ){
        if (k < 0) return 0;

        int left = 0;
        int right = 0;
        int sum = 0;
        int c = 0;

        int[] freq = new int[a.length+1];

        while (right < a.length){
            if(freq[a[right]] == 0){
                c++;
            }
            freq[a[right]]++;


            while (c > k){
                freq[a[left]]--;
                if(freq[a[left]] == 0){
                    c--;
                }
                left++;
            }

            sum += right - left + 1;
            right++;
        }

        return sum;
    }
}