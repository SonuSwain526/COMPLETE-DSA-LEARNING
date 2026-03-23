import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
//        int[] a = new int[3];
//        int[] b = new int[3];
        int x = 0, y=0;
        for (int i = 0; i < 3; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a > b) x++;
            if(b > a) y++;
        }

        System.out.println(Arrays.toString(new int[]{x, y}));
    }
}
