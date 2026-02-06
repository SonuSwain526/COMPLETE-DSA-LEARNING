import java.util.Scanner;

public class Partten7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("entere the row size : ");
        int n = in.nextInt();
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<i; j++){
                if((i+j)%2 == 0){
                    System.out.print(0);
                }
                else
                    System.out.print(1);
            }
            System.out.println();
        }
    }
}
