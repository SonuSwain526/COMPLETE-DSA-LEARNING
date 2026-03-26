import java.util.ArrayList;
import java.util.List;

public class Lc90med {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2,3}));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> xx = new ArrayList<>();
        x(nums, 0, new ArrayList<>(), xx);
        return xx;
    }
    public static void x(int[] n, int ix, List<Integer> temp, List<List<Integer>> ans){
        if(ix == n.length){

            return;
        }if(ix > n.length) return;
        ans.add(new ArrayList<>(temp));
        for(int i = ix; i < n.length; i++){
            if(i != ix && n[i] == n[i-1]) continue;

            temp.add(n[i]);
            x(n, i+1, temp, ans);
            temp.remove(temp.size()-1);
//            x(n, i+1, temp, ans);
        }
    }
}
