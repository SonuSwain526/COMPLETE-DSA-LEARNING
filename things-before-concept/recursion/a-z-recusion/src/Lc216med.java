import java.util.ArrayList;
import java.util.List;

public class Lc216med {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> list = new ArrayList<>();
        x(a, 0, 4,0, 1, list, new ArrayList<>());
        System.out.println(list);

    }
    public static void x(int[] x, int ix,int size, int sum, int t, List<List<Integer>> list, List<Integer> temp){
        if(sum == t && temp.size() == size){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(ix >= x.length|| temp.size() > size || sum > t)return;

        temp.add(x[ix]);
        x(x, ix+1,size, sum + x[ix], t, list, temp);
        temp.remove(temp.size()-1);
        x(x, ix+1,size, sum, t, list, temp);
    }
}
