import java.util.ArrayList;
import java.util.Arrays;

public class NdigiitnoWitincreseingoorder {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        ArrayList<Integer> ans = new ArrayList<>();
        x(2,arr, 0, ans, 0);
        System.out.println(ans);
    }
    public static void x(int n,int[] arr,int no, ArrayList<Integer> ans, int ix){
        if(n == 1) ans.addAll(Arrays.asList(0,1, 2, 3, 4, 4, 5));
        if(((int)Math.log10(no) + 1) == n){
            ans.add(no);
            return;
        }

        for (int i = ix; i < arr.length; i++) {
            int curno = (int) (arr[i] + no * Math.pow(10, ((int)Math.log10(no) + 1)));
            x(n, arr, curno, ans, i+1);
        }
    }
}
