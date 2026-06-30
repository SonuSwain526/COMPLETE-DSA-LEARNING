class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return subArr(nums, k) - subArr(nums, k-1);
    }

    public int subArr( int[] a, int k){
        if ( k < 0 ) return 0;

        int left = 0;
        int right = 0; 
        int total = 0;
        int c = 0;

        while( right < a.length ){
            if (a[right] % 2 != 0) c++;

            while ( c > k){
                if (a[left] % 2 != 0) c--;
                left++;
            }

            total += right - left + 1;
            right++;
        }

        return total;
    }
}