import java.util.*;

public class Lc15med {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,1,1,1,2,-1,-3};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] n) {
        Arrays.sort(n);
        List<List<Integer>> x = new ArrayList<>();
        for (int i = 0; i < n.length; i++) {
            for (int j = i+1; j < n.length; j++) {
//                if (n[i] != n[j]) {
                    int curEl = -(n[i] + n[j]);
                    bs(x, n, j + 1, n.length - 1, curEl, n[i], n[j]);
                }
//            }
        }

        Set<List<Integer>> set = new HashSet<>(x);   // remove duplicates

        // convert back to List<List<Integer>>

        return new ArrayList<>(set);
    }
    public static void bs(List<List<Integer>> x,int[] y, int s, int e, int t, int a, int b){
        int pe = Integer.MIN_VALUE;
        while (s<=e){
            int mid = s + (e - s)/2;
            if(y[mid] == t && y[mid] != pe){x.add(Arrays.asList(a, b, y[mid])); pe = y[mid];}
            if(y[mid] > t){ e = mid - 1;}
            else{ s = mid+1;}
            pe = y[mid];
        }
    }
}
