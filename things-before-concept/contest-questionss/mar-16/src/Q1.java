import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] x = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                x[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(x[i][0] % x[i][1]);
//            System.out.println(x[i][0] / x[i][1]);


        }
        System.out.println();
    }
}
