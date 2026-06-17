import java.util.ArrayList;

public class lc2498 {
    public static void main(String[] args) {
        maxju(new int[]{1,2,3}, new boolean[]{}, 0, new ArrayList<>());
    }
    public static void maxju(int[] x, boolean[] b, int ix, ArrayList<Integer> ar){
        if(ix >= x.length){
            System.out.println(ar);
            return;
        }
        ar.add(x[ix]);
        maxju(x, b, ix + 1, ar);
        ar.removeLast();
        maxju(x,b, ix+1, ar);
    }

    public static int max(ArrayList<Integer> x, int a, int b){
        int max = Integer.MIN_VALUE;

        for
    }
}
