public class Lc5med {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("baabc"));
    }
    public static String longestPalindrome(String s) {
        int l = 0, r = s.length();

        int n = s.length();
//        StringBuilder xx = new StringBuilder()
        String xx = "";
        String xy = "";

        while (l < r){
            StringBuilder sb = new StringBuilder();
            sb.append(s, l, r);
            boolean x = false;
            if(sb.reverse().compareTo(new StringBuilder(s.substring(l, r))) == 0){
                xx = s.substring(l, r);
                x = true;
            }

            if(x){
                break;
            }
            else r--;
            if(s.charAt(l) != s.charAt(r)){
                l++;
            }
        }
        while (l < r){
            StringBuilder sb = new StringBuilder();
            sb.append(s, l, r);
            boolean x = false;
            if(sb.reverse().compareTo(new StringBuilder(s.substring(l, r))) == 0){
                xy = s.substring(l, r);
                x = true;
            }
            if(x){
                break;
            }else l++;
        }
        if(xx.length() >= xy.length()){
            return xx;
        }else
            return xy;
    }
//    public static boolean check(String ){
//
//    }
}
