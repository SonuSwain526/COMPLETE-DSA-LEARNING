import java.util.Scanner;

public class Contest0703 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        int z = 0;
        int ix = 0;
        while (ix<x.length-1){
            if(x[ix] > x[ix+1]){
                x[ix+1]++;
                z++;
            }else ix++;
        }
        System.out.println(z);
    }
}
