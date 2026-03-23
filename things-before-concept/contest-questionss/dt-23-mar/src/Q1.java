import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            check(sc);
        }
    }
    public static void check(Scanner sc){
        int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();

        if(A+B+C == 180) System.out.println("YES");
        else System.out.println("NO");
        return;
    }
}
