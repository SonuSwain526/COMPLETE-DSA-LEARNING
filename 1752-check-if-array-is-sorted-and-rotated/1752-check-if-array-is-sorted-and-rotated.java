class Solution {
    public boolean check(int[] nums) {
        int t = 0;
        // for( int i = 0; i < nums.length-1; i++){
        //     if(nums[i] <= nums[i+1]){
        //         t = i+1;
        //     }else {
        //         // t = i;/
        //         break;
        //     }
        // }
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1]) t++;
            if(t > 1) return false;
        }

        
        if(t == 0) return true;
        if(t == 1 && nums[0] < nums[nums.length-1]) return false;

        return true;
    }
}