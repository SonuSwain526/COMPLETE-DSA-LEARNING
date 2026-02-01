import java.util.Scanner;

public class NoAccurances {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("entere your number : ");
        long no = input.nextLong();
        System.out.print("entere the number u wanna count : ");
        int findingNo = input.nextInt();
        int count = 0;
        while(no > 0){
            double lastNo = no % 10;
            if ( lastNo == findingNo){
                count++;
            }
            no = no / 10;
        }
        System.out.println("the number no appearing " +count+ " times");
    }
}
