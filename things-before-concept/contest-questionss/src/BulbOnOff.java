import java.util.*;

public class BulbOnOff {
    public static void main(String[] args) {
        int[] x = {7,1,2,3,4,1,2};
        List<Integer> y = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < x.length; i++) {
            int count = 0;
            for (int j = 0; j < x.length; j++) {
                if(x[i] == x[j]){
                    count++;
                }
            }
            System.out.println(count);
            if(count > 1 && count % 2 != 0){
                y.add(x[i]);
            }
            if(count == 1){
                y.add(x[i]);
            }
        }

        Set<Integer> set = new HashSet<>(y);

// Convert to array
        Integer[] uniqueArray = set.toArray(new Integer[0]);

        Arrays.sort(uniqueArray);
        System.out.println(Arrays.toString(uniqueArray));
    }
}
