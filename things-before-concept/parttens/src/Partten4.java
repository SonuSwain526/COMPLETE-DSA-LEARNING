import java.util.Scanner;
public class Partten4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter the row size : ");
        int n = in.nextInt();
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j<i; j++){
                System.out.print(" ");
            }
            for(int a = 0; a <((n*2) + 1) - 2*i; a++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
