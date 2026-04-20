import java.util.ArrayList;
import java.util.List;

public class Lc526med {
    public static void main(String[] args) {
        List<List<Integer>> x = new ArrayList<>();

        System.out.println(comb(new ArrayList<>(), new int[]{1}, new boolean[3]));

        System.out.println(x);
    }
    public static int countArrangement(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        return comb(new ArrayList<>(), arr, new boolean[n]);
    }
    public static int comb(List<Integer> l, int[] in, boolean[] b){
        if(l.size() >= in.length){
            for (int i = 0; i < l.size(); i++) {
                if(factorial(l.get(i)) % (i+1) != 0 && (i+1) % factorial(l.get(i)) != 0){
                    return 0;
                }
            }
            return 1;
        }
        int r = 0;
        for (int i = 0; i < in.length; i++) {
            if(b[i]) continue;
            b[i] = true;
            l.add(in[i]);
            r += comb(l, in, b);
            l.removeLast();
            b[i] = false;
        }
        return r;
    }
    public static long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
