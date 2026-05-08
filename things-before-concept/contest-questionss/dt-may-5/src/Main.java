import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            int X = sc.nextInt();
//            int Y = sc.nextInt();
//
////            if(Y * 2 <= X){
////                System.out.println("YES");
////            }else System.out.println("NO");
//            System.out.println(Math.abs(X-Y));
//        }

        String s = sc.nextLine();
//        String ans = s;
//
//        for (int i = 1; i < s.length(); i++) {
//            String rotated = s.substring(i) + s.substring(0, i);
//            if (rotated.compareTo(ans) < 0) {
//                ans = rotated;
//            }
//        }
//
//        System.out.println(ans); // abac

            String str = s + s;
            int n = s.length();

            int i = 0, j = 1, k = 0;

            while (i < n && j < n && k < n) {
                char a = str.charAt(i + k);
                char b = str.charAt(j + k);

                if (a == b) {
                    k++;
                } else if (a > b) {
                    i = i + k + 1;
                    if (i <= j) i = j + 1;
                    k = 0;
                } else {
                    j = j + k + 1;
                    if (j <= i) j = i + 1;
                    k = 0;
                }
            }

            int start = Math.min(i, j);
            System.out.println(str.substring(start, start + n));
    }
}