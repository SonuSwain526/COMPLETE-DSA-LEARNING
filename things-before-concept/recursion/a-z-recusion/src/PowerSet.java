import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        int[] nums = {1,2,3};
        ArrayList<Integer> temp = new ArrayList<>();
        x(l, 0, temp, nums);
        System.out.println(l);
    }
    public static void x(List<List<Integer>> l, int i, ArrayList<Integer> temp, int[] nums){
        if(i == nums.length){ l.add(new ArrayList<>(temp));return;}

//        l.add(new ArrayList<>(temp));
        if(i< nums.length) temp.add(nums[i]);
        x(l, i+1, temp, nums);
        temp.removeLast();
        x(l, i+1, temp, nums);
    }
}
