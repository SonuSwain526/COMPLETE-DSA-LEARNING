import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n];
//        int[] p = {3,2,7,4,1};
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        System.out.println(x(p,0,17,0,2000));


//
//        int[] pp = new int[n];
//        int[] ss = new int[n];
//        pp[0] = 0; ss[n-1] = 0;
//        for (int i = 0; i < n-1; i++) {
//            pp[i+1] = pp[i] + p[i];
//        }
//        for (int i = n-2; i >= 0; i--) {
//            ss[i] = ss[i+1] + p[i+1];
//        }
//
//        System.out.println(Arrays.toString(ss));
//        System.out.println(Arrays.toString(pp));
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < n-1; i++) {
//            if(ans > Math.abs(pp[i+1] - ss[i])){
//                ans = Math.abs(pp[i+1] - ss[i]);
//            }
//        }
//        System.out.println(ans);
//        int n = sc.nextInt();
//        int[] ar = new int[n];
//        for (int i = 0; i < n; i++) {
//            ar[i] = sc.nextInt();
//        }
//        Arrays.sort(ar);
//        int c = 0;
//        int ix = 0;
//        while (ix < n){
//            if(ix+1 < n && ar[ix] == ar[ix+1]) {
//                c++;
//                ix += 2;
//            }else ix++;
//        }
//        System.out.println(c);
//
//        float X = sc.nextFloat();
//        float Y = sc.nextFloat();
//        if(X % 5 == 0) {
//            if(Y < X) {
//                System.out.println(Y);
//            }else {
//                System.out.println(Y - X - 0.5);
//            }
//        }else
//            System.out.println(Y);
    }

    public static int x(int[] ar, int ix, int sum,int s, int ans){
        if(ix == ar.length){
            int a = Math.abs(s - (sum - (s)));
            if(a < ans){
                return a;
            }
            return ans;
        }if(ix > ar.length) return ans;

        int aa = ans;
        aa = x(ar, ix+1, sum, s+ar[ix], aa);
        aa = x(ar, ix+1, sum, s, aa);
//        aa = x
        return aa;
    }
}