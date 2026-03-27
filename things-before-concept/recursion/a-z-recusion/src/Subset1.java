import java.util.ArrayList;
import java.util.List;

public class Subset1 {
    public static void main(String[] args) {
        System.out.println(subsetSums(new int[]{5,2,1}));
    }
    public static List<Integer> subsetSums(int[] nums) {
        //your code goes here
        List<Integer> l = new ArrayList<>();
        x(nums, 0, 0, l);
        return l;
    }
    public static void x(int[] n, int ix, int sum, List<Integer> list){
        if(ix >= n.length){
            list.add(sum);
            return;
        }

//        list.add(sum);
        x(n, ix+1, sum + n[ix], list);
        x(n, ix+1, sum, list);

    }
}
