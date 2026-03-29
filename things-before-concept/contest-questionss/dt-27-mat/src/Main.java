import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            int N = sc.nextInt();
//            if(N < 10) System.out.println("Thanks for helping Chef!");
//            else System.out.println(-1);

//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            long quantity = sc.nextLong();
//            long price = sc.nextLong();
//            long result = quantity * price;
//            if(quantity > 1000){
//                System.out.println(result - (result * 0.1));;
//            }else System.out.println(result);
//        }

//        int n = sc.nextInt();
//        int[] x = new int[n];
//        for (int i = 0; i < n; i++) {
//            x[i] = sc.nextInt();
//        }
//        Arrays.sort(x);
//        List<Integer> list = new ArrayList<>();
//        gen(0,0,x,list);
//        List<Integer> result = list.stream()
//                .distinct()
//                .sorted()
//                .skip(1)
//                .toList();
//
//        System.out.println(result.size());
//
//        // print elements (space separated)
//        for (int num : result) {
//            System.out.print(num + " ");
//        }
//
//    }
//
//    public static void gen(int ix, int sum, int[] x, List<Integer> y){
//        if (ix == x.length) {
//            y.add(sum);
//            return;
//        }
//        if(ix > x.length)return;
//
//        gen(ix+1, sum + x[ix], x, y);
//        gen(ix + 1, sum, x, y);

        int[][] arr = new int[5][5];
        int x = 0, y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1){
                    x = i; y = j;
                }
            }
        }
        if(x == 2 && y == 2){
            System.out.println(0);
            return;
        }
        int c =0;
        while (x < 3 && y < 3){
            if(x < 2){
                x++;
                c++;
            }
            else if(x > 2){
                x--;
                c++;
            }
            if(y <= 2) {
                y++;
                c++;
            }
            else {
                y--;
                c++;
            }
        }


    }
}