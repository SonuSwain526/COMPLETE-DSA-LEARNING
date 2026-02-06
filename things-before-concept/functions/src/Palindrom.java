import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter ur number : ");
        int num = in.nextInt();
        System.out.println(checkPall(234));
        if(num == checkPall(num)){
            System.out.println("yess it iss...");
        }
        else
            System.out.println("oops its not sorry.");
    }
    public static int checkPall(int num){
//        int temp = 0;
//        int count = 0;
//        int dump = num;
//        while(dump>0){
//            count++;
//            dump = dump/10;
//        }
        int reverese = 0;

        while(num>0){
            int rem = num % 10;
            reverese = reverese * 10 + (rem);
            num = num/10;
        }
        return reverese;
    }
}
