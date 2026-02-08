import java.util.Arrays;

public class PermArr {
    public static void main(String[] args) {
        int[] arr = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(perm(arr)));
    }

    static int[] perm(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr[arr[i]];
        }
        return ans;
    }
}
