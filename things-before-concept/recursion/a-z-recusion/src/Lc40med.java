import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc40med {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1,2,2,2,5}, 5));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> x = new ArrayList<>();
        Arrays.sort(candidates);
        x(candidates, target, 0, 0, x, new ArrayList<>());
        return x;
    }
    public static void x(int[] c, int t, int sum, int ix, List<List<Integer>> ans, List<Integer> cur){
        if(sum == t){
            ans.add(new ArrayList<>(cur));
            return;
        }else if(sum > t || ix >= c.length)return;

        for (int i = ix; i < c.length; i++) {
            if(i != ix && c[i-1] == c[i])continue;

            cur.add(c[i]);
            x(c, t, sum + c[i], i + 1, ans, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
