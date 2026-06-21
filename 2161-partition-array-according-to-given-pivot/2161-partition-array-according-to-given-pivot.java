class Solution {
    public int[] pivotArray(int[] nums, int p) {
        int n = nums.length;
        int[] x = new int[n];
        int j = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < p){
                x[j] = nums[i];
                j++;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(nums[i] == p){
                x[j] = nums[i];
                j++;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > p){
                x[j] = nums[i];
                j++;
            }
        }
        return x;
    }
}