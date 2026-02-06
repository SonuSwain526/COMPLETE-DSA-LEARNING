import java.util.Scanner;

public class Partten6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("entere the size of row : ");
        int n = in.nextInt();
        for(int i = 0 ; i < n+1; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0 ; i < n+1; i++){
            for(int j = 0; j < n - i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
