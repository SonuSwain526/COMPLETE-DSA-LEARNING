public class dt_may_10 {
    public static void main(String[] args) {
        int[] a = {1,0,2};
        System.out.println(maximumJumps(a, 1));
    }
    public static int maximumJumps(int[] nums, int target) {
        int i = 0;
        int j = 1;
        int s = 0;
        while (i < nums.length && j < nums.length){
            int x = nums[j] - nums[i];

            if(x <= target && x >= -target){
                s++;
                i = j;
            }
            j++;
        }

        if(i == nums.length-1){
            return s;
        }else return -1;
    }
}
