import java.util.Arrays;

public class Lc2615med {
    public static void main(String[] args) {
        int[] x = {1,3,1,1,2};
//        distance(x);
        System.out.println(Arrays.toString(distance(x)));

    }
    public static long[] distance(int[] nums) {
        long[] x = new long[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int cur = nums[i];
//            long sum = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if(i != j && nums[i] == nums[j]){
//                    sum += Math.abs(i - j);
//                }
//            }
//            x[i] = sum;
//            sum = 0;
//        }

        int[][] pair = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i]; // value
            pair[i][1] = i;      // original index
        }
        Arrays.sort(pair, (a, b) -> a[0] - b[0]);
        System.out.println();
        long sum = 0;
        int uc = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(pair[i][0] == pair[i+1][0]){
                sum += Math.abs(pair[uc][1] - pair[i+1][1]);
            }else {
                x[pair[uc][1]] = sum;
                sum = 0;
                uc = pair[i+1][1];
            }
        }

        int m = 0;

        while (m < nums.length){
            int n = 0;
            for (int i = m; i < nums.length; i++) {
                if(pair[i][0] != pair[i+1][0]){
                    n = i+1;
                    break;
                }
            }

            for (int i = m; i < n; i++) {
//                x[m] =
            }
        }

        return x;
    }
}
