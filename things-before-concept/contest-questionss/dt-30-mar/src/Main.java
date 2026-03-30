import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int x = sc.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int c = 0;
////        Arrays.sort(a);
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += a[j];
//                if(sum == x){
//                    c++;
//                }
//            }
//        }
//        System.out.println(c);

//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            System.out.println((x*(x-1))/2);
//        }

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int A = sc.nextInt(),
                    B = sc.nextInt(),
                    X = sc.nextInt(),
                    Y = sc.nextInt();

            if(A * B > X*Y) System.out.println("NO");
            else System.out.println("YES");
        }
//        System.out.println(x(0, x, 0,0, a));
    }
//    public static int x(int ix, int t, int c,int sum, int[] a){
//        if(sum == t){
//            return c+1;
//        }if(ix >= a.length){
//            return c;
//        }
//
//        int cou = c;
//        cou = x(ix+1, t, cou, sum + a[ix], a);
//        cou = x(ix + 1, t, cou, sum, a);
//        return cou;

//        int T = new sc()
//    }
}