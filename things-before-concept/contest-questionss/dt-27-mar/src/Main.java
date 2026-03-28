import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            int X = sc.nextInt();
//            if(X > 100) System.out.println(X-10);
//            else System.out.println(X);
//        }

//        int n = sc.nextInt();
//
//        int digit = (int) (Math.log10(n) + 1);
//        int c = 0;
//        while (n > 0){
//            int max = Integer.MIN_VALUE;
//            int x = n;
//            while (x > 0){
//                if(max < x % 10){
//                    max = x % 10;
//                }
//                x = x / 10;
//            }
//            n = n - max;
//            c++;
//        }
//        System.out.println(c);


        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] ar = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            if(ar[i] < min) min = ar[i];
        }
        int l = 1, r = min * t;

        while (l <= r){
            int mid = l + (r - l)/2;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum = sum + mid/ar[i];
            }
            if(sum == t){
                System.out.println(mid);
                return;
            }else if(sum < t){
                l = mid + 1;
            }else r = mid -1;
        }

    }
}