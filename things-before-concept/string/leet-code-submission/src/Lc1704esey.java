public class Lc1704esey {
    public static void main(String[] args) {
        halvesAreAlike("heeloo");
    }
    public static void halvesAreAlike(String s) {
        int c = 0, d = 0;
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if("aeiouAEIOU".indexOf(s.charAt(i)) != -1){
                c++;
            }
            if("aeiouAEIOU".indexOf(s.charAt(i + n/2)) != -1){
                d++;
            }
        }
        System.out.println(c);
        System.out.println(d);
    }
}
