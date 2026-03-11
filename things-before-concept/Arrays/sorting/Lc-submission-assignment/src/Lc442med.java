import java.util.ArrayList;
import java.util.List;

public class Lc442med {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n + 1];
        for (int i : nums) {
            newArr[i]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] >= 2) {
                list.add(i);
            }
        }
        return list;
    }
}
