public class Lc169esey {
    public int majorityElement(int[] nums) {
        // for(int i = 0; i<nums.length; i++){
        //     int c = 0;
        //     for(int j = 0; j<nums.length; j++){
        //         if(nums[i] == nums[j]){
        //             c++;
        //         }
        //     }
        //     if(c > nums.length/2){

        //         return nums[i];
        //     }
        // }
        // return 0;



        int x = 0;
        int y = 0;
        for(int i = 0; i<nums.length; i++){
            if(x == 0){
                y = nums[i];
                x++;
            }else if(y == nums[i]){
                x++;
            }else x--;
        }
        return y;
    }
}
