public class Lc1513med {
    public static void main(String[] args) {
        System.out.println(numSub("1111"));
    }
    public static int numSub(String s) {
        int c = 0;
        int sum = 0;
        int mod = 1000000007;
        for(char x: s.toCharArray()){
            if(x == '1'){
                c++;
                sum += c;
            }else c = 0;
            sum = sum % mod;
        }
        return sum;
    }

}