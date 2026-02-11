public class GoodPairs {
    public static void main(String[] args) {
        int count = 0;
        int x = 0;
        int[] nums = {1,2,3,1,1,3};
        int z = nums.length;
        while(x<nums.length){
            int y = 1;
            for(int i = y; i<z-1; i++){
                if(nums[x] <= nums[i]){
                    count++;
                }
            }
            z--;
            x++;
        }
        System.out.println(count);
    }
}
