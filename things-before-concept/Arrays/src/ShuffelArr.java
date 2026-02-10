import java.util.Arrays;

public class ShuffelArr {
    public static void main(String[] args) {
        int[] nums= {1,2,3,2,3,4};
        int n = 3;
        int[] x = new int[n*2];
        int y =0;
        for(int i=0; i<n; i++){
            x[y++] = nums[i];
            x[y++] = nums[i+n];
        }
        System.out.println(Arrays.toString(x));

    }
}
