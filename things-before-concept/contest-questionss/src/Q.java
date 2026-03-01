import java.util.HashSet;
import java.util.Set;

public class Q {
    public static void main(String[] args) {
        int[] x = {2, 3, 2, 2, 3};
        Set<Integer> set = new HashSet<>();

        for (int num : x) {
            set.add(num);
        }
        System.out.println(set.size());
    }
}
