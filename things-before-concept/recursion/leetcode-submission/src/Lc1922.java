public class Lc1922 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(30));
    }
    public static int countGoodNumbers(long n) {
        long p = n / 2;
        int x = pow(p, 20);

        if (n % 2 == 1) {
            return (x * 5) % mod;
        }
        return x;
    }
    public static int pow(long p, int base){
        if(p == 0) return 1;

        int half = pow(p/2, base);

        int res = (half * half) % mod;

        if( p % 2 == 1){
            res = (half * base) % mod;
        }

        return res;
    }
//    public static long x(long n){
//        int x = 1000000007;
//        if(n == 1) { return 5;}
//        long c = x(n / 2);
//        if(((n - (n /2) + 1) % 2 == 0)){
//            return (long) (c * Math.pow(20, (double) n /2));
//        }else
//            if(n % 2 == 0)
//                return (long) (c * Math.pow(20, ((double) n / 2)) * 5L);
//            else
//                return (long) (c * Math.pow(20, ((double) n / 2)) * 4L);
//    }
}
