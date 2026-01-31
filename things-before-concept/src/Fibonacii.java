import java.util.Scanner;
public class Fibonacii {
    public static void main(String[] args) {
        int a = 0, b = 1;
        int i = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("enter the length of fibonacii : " );
        int ip = input.nextInt();
//        System.out.println(0);
        while ( i < ip){
            int c = a+b;
            System.out.println(a);
            a =b;
            b = c;
            i++;
        }
    }
}
