public class Lc287med {
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        //     for(int j = 0; j < nums.length-1; j++){
        //         if(nums[j] == nums[j+1]){
        //             return nums[j];
        //         }
        //     }
        for(int x: nums){
            int ix = Math.abs(x);
            if(nums[ix]<0){
                return ix;
            }nums[ix] = -nums[ix];
        }
        return 0;
    }
}
