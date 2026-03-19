import java.util.Scanner;

public class GeekOnaciiNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fun(sc.nextInt(), sc);
    }
    public static void fun(int t, Scanner sc){
        if(t == 0) return;
        int A = sc.nextInt(),
                B = sc.nextInt(),
                C = sc.nextInt(),
                n = sc.nextInt();

        outerOne(A, B, C, n, 4);
        fun(t-1 ,sc);
    }
    public static void outerOne(int a, int b, int c, int n, int i){
//        if(n == 4) System.out.println(a+b+c);
        int s = a+b+c;
        if(n == i){
            System.out.println(s);
            return;
        }
        outerOne(b, c, s, n , i+1);
    }
}
