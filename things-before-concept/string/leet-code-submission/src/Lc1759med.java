public class Lc1759med {
    public static void main(String[] args) {
        System.out.println(countHomogenous("a"));
    }
    public static int countHomogenous(String s) {
        int i = 0;
        int j = 0;

        int sum = 0;
        int c = 0;

        while (i < s.length() && j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                c++;
                sum += c;
                j++;
            }else{
                i = j;
                c = 0;
            }
        }
        return sum;
    }
}
