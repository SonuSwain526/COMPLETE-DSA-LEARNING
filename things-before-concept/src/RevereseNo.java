import  java.util.Scanner;

public class RevereseNo {
    public static void main(String[] args) {
        int reverseNo = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("enter a no that u wanna reverese : ");
        int no = input.nextInt();
//        int nc = no;
//        int len = 0;
//        while(nc > 0){
//            len++;
//            nc = nc / 10;
//        }
//        while(no>0){
//            int lastno = no % 10;
//            reverseNo = reverseNo + lastno * (int)(Math.pow(10, (len - 1)));
//            len--;
//            no = no / 10;
//        }

        while (no > 0){
            int rem = no % 10;
            reverseNo = reverseNo * 10 + rem;
            no = no / 10;
        }
        System.out.println("reveresed no is : " + reverseNo);
    }
}
