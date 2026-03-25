import java.util.ArrayList;

public class ExistOrnotSumOfK {
    public static void main(String[] args) {
        System.out.println(checkSubsequenceSum(new int[]{1,2,3,4}, 7));
    }

    public static boolean checkSubsequenceSum(int[] nums, int k) {
        //your code goes here
        return x(nums, k, 0, 0, false, new ArrayList<>());
    }

    public static boolean x(int[] n, int k, int sum, int ix, boolean c, ArrayList<Integer> x){
        if(sum == k || c){
            return true;
        } else if (sum > k || ix >= n.length) {
            return false;
        }
        x.add(n[ix]);
        boolean temp = c;
        temp = x(n, k, sum + n[ix], ix+1, temp, x);
        x.remove(x.size()-1);
        return x(n, k, sum, ix+1, temp, x);
    }
}
