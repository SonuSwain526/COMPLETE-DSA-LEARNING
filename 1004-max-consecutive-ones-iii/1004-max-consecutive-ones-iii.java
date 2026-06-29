class Solution {
    public int longestOnes(int[] nums, int k) {
        // int cur0 = k
        int n = nums.length;

        if(k == n) return n;
        
        int maxSize = Integer.MIN_VALUE;
        int size = 0;
        int j = 0;

        if(k == 0){
            for (int i = 0; i < n; i++){
                if(nums[i] == 0){
                    size = 0;
                }else size++;

                maxSize = Math.max(maxSize, size);
            }
        }
        else{
        for ( int i = 0; i < n; i++){
            if(nums[i] == 0 && k == 0){
                    while(j < n){
                        if(nums[j] == 0) {j++; k++; size--; break;}
                        size--;
                        j++;
                    }
            }if(nums[i] == 0){
                k--;
            }
            size++;
            maxSize = Math.max(size, maxSize);
        }
        }

        return maxSize;
    }
}