import java.util.Arrays;

public class Lc801hard {
    public static void main(String[] args) {
        int[] x = {0,7,8,10,10,11,12,13,19,18}; int[] y = {4,4,5,7,11,14,15,16,17,20};
        System.out.println(minSwap(x, y));

    }

    public static int minSwap(int[] nums1, int[] nums2) {
        int[] nums1c = Arrays.copyOf(nums1, nums1.length);
        int[] nums2c = Arrays.copyOf(nums2, nums2.length);
        int ix = 0;
        int c = 0;
        while (ix < nums1.length-1){
            if((nums1[ix] < nums1[ix+1]) && nums2[ix] < nums2[ix+1]){
                ix++;
            }else {
                swap(nums1, nums2, ix+1);
                c++;
            }
        }

        int ixx = 0;
        int cc = 0;
        while (ixx < nums1c.length-1){
            if((nums1c[ixx] < nums1c[ixx+1]) && nums2c[ixx] < nums2c[ixx+1]){
                ixx++;
            }else {
                swap(nums1c, nums2c, ixx);
                cc++;
            }
        }



        return Math.min(c,cc);
    }
    public static void swap(int[] x, int[] y, int i){
        int temp = x[i];
        x[i] = y[i];
        y[i] = temp;
    }
}
