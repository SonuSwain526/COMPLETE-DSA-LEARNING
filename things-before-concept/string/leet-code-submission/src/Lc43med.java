import java.math.BigInteger;

public class Lc43med {
    public static void main(String[] args) {
        System.out.println(multiply("10", "20"));
    }
    public static String multiply(String n1, String n2) {
        if(n1.equals("0") || n2.equals("0")) return "0";
        BigInteger ans = makeIng(n1).multiply(makeIng(n2));
        return makeString(ans);
    }
    public static BigInteger makeIng(String x){
        BigInteger ans  = BigInteger.valueOf(0);
        for (int  i= 0; i < x.length(); i++) {
            ans = ans.add(BigInteger.valueOf(x.charAt(i) - '0').multiply(BigInteger.TEN.pow(x.length() - i - 1)));;
        }
        return ans ;
    }
    public static String makeString(BigInteger x){
        StringBuilder s = new StringBuilder();
        while (x.compareTo(BigInteger.ZERO) > 0) {
            BigInteger cur = x.mod(BigInteger.TEN);
            s.append((char)(48 + cur.intValue()));
            x = x.divide(BigInteger.TEN);
        }
        return s.reverse().toString();
    }
}
