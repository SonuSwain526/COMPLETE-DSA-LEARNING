public class Lc3783esey {
    public static void main(String[] args) {

    }
    public static int mirrorDistance(int n) {
        int c = n;
        int revno = 0;
        while (n > 0){
            revno += (int) (n % 10 * Math.pow(10, (int)Math.log10(n) + 1));
            n = n/10;
        }
        return Math.abs(revno - c);
    }
}
