import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MejorityElem {
    public static void main(String[] args) {
        int[] x = {1,2,1,2,2,3,3,1};
        int val = x.length/3;
//        if(x.length%2 == 0){
//            val = x.length/2 -1;
//        }
        List<Integer> y = new ArrayList<>();
        int pointer = 0;
        Set<Integer> set = new HashSet<>();

        for(int num : x) {
            set.add(num);
        }
        int[] uniqueArr = new int[set.size()];
        int index = 0;

        for(int num : set) {
            uniqueArr[index++] = num;
        }

        for (int j : uniqueArr) {
            System.out.println(j);
            if ((val)<ck(j, x) && x.length != 2) {
                y.add(j);
//                System.out.println(1);
            } else if (x.length == 2) {
                y.add(j);
            }
        }
        System.out.println(y);
    }
    static int ck(int a, int[] arr){
        int count = 0;
        for(int x: arr){
            if(x == a){
                count++;
            }
        }
        return count;
    }
}
