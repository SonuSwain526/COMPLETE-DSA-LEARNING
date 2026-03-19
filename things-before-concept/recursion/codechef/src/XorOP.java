import java.util.Scanner;

public class XorOP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fun(sc.nextInt());
    }
    public static void fun(int m){
        if(m == 0) return;;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        if(n % 3 == 0) System.out.println(a);
        if(n % 3 == 1) System.out.println(b);
        if(n % 3 == 2) System.out.println(a ^ b);
        fun(m-1);
    }


}
