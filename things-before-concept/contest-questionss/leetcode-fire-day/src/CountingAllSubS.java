import java.util.ArrayList;

public class CountingAllSubS {
    public static void main(String[] args) {
        System.out.println(countSubsequenceWithTargetSum(new int[]{4, 2, 10, 5, 1, 3}, 5));
    }
    public static int countSubsequenceWithTargetSum(int[] nums, int k) {
        //your code goes here
        return x(nums, k, 0, 0, 0, new ArrayList<>());
    }
    public static int x(int[] n, int k, int sum, int ix, int c, ArrayList<Integer> x){
        if(sum == k){
            return c+1;
        } else if (sum > k || ix >= n.length) {
            return c;
        }
        x.add(n[ix]);
        int count = c;
        count = x(n, k, sum + n[ix], ix+1, count, x);
        x.remove(x.size()-1);
        count = x(n, k, sum, ix+1, count, x);
        return count;
    }
}
