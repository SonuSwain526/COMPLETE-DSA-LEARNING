import java.util.Scanner;

public class Partten5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("entere the row size : ");
        int n = in.nextInt();
        for(int i = 0; i< n+1; i++){
            for(int j = 0; j <n - i; j++){
                System.out.print(" ");
            }
            for(int z = 0; z < ((i*2)+1);z++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 0; i< n+1; i++){
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(int z = 0; z < ((n*2)+1) - 2*i;z++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
