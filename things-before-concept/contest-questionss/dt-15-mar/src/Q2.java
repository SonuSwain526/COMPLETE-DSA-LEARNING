import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }

        Arrays.sort(x);

        long sum = 0;
        int j = 0;

        for (int i = n - 1; i >= 0; i--) {
            sum += x[i] * (1L << j);
            j++;
        }

        System.out.println(sum);
    }
}