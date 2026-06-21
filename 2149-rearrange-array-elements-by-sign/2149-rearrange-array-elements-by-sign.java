class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        // int[] a = new int[n / 2];
        // int[] b = new int[n/2];
        // int x = 0, y = 0;

        // for(int i = 0; i < n; i++){
        //     if(nums[i] < 0) {
        //         a[x] = nums[i];
        //         x++;
        //     }else{
        //         b[y] = nums[i];
        //         y++;
        //     }
        // }
        // x = 0;
        // y = 0;
        // for(int i = 0; i < n; i++){
        //     if( i % 2 != 0){
        //         nums[i] = a[x];
        //         x++;
        //     }else{
        //         nums[i] = b[y];
        //         y++;
        //     }
        // }
        // return nums;

        int[] x = new int[n];
        int a = 0, b = 1;

        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                x[a] = nums[i];
                a += 2;
            }else {
                x[b] = nums[i];
                b += 2;
            }
        }
        return x;
    }
}