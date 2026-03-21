public class Lc1922 {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(30));
    }
    public static int countGoodNumbers(long n) {
        return Math.toIntExact(x(n));
    }
    public static long x(long n){
        int x = 1000000007;
        if(n == 1) { return 5;}
        x(n-1);
        if(n % 2 == 0) return (x(n-1) * 4L) % x;
        else return (x(n-1) * 5L) % x;
    }
}
