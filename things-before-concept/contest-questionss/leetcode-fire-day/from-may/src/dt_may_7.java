import java.util.Arrays;

public class dt_may_7 {
    public static void main(String[] args) {
        int[] ans = new int[5];
        boolean[] b = new boolean[5];
        int[] a = {30,21,5,35,24};
        int max = Integer.MIN_VALUE;
        for (int j : a) {
            max = Math.max(max, j);
        }
        for (int i = 0; i < a.length; i++) {
            ans[i] = x(a, b, a[i], max, i);
        }
        System.out.println(Arrays.toString(ans));
    }
    public static int x(int[] a, boolean[] b,int cm, int max, int ix){
        if(cm == max){
            return max;
        }
//        if(cm)

        b[ix] = true;

        for (int i = 0; i < b.length; i++) {
            if(ix != i && !b[i]){
                if(ix < i && a[ix] > a[i]){
                    cm = Math.max(cm,
                            x(a, b, Math.max(cm, a[i]), max, i));
                } else if (ix > i && a[ix] < a[i]) {
                    cm = Math.max(cm,
                            x(a, b, Math.max(cm, a[i]), max, i));

                }
            }
        }
        b[ix] = false;
        return cm;
    }
}
