import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int pl = -1;
        for (int i = 0; i < sc.nextInt(); i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            if(Math.abs((a - b)) > max){
                max = Math.abs((a - b));
                if(a > b){
                    pl = 1;
                }else pl = 2;
            }
        }
        System.out.println(max + "," + pl);
    }
}
