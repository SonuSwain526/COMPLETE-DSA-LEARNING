import java.util.*;

public class Lc16med {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,1,1,1,2,-1,-3};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] n) {
        Arrays.sort(n);
        List<List<Integer>> x = new ArrayList<>();

        for (int i = 0; i < n.length; i++) {

            if (i > 0 && n[i] == n[i - 1]) continue;

            for (int j = i + 1; j < n.length; j++) {
                if (j > i + 1 && n[j] == n[j - 1]) continue;

                int curEl = -(n[i] + n[j]);
                bs(x, n, j + 1, n.length - 1, curEl, n[i], n[j]);
            }
        }

        return x;
    }

    public static void bs(List<List<Integer>> x, int[] y, int s, int e, int t, int a, int b) {

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (y[mid] == t) {
                x.add(Arrays.asList(a, b, y[mid]));
                return;
            }

            if (y[mid] > t) e = mid - 1;
            else s = mid + 1;
        }
    }
}
