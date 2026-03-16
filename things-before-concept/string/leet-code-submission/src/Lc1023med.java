import java.util.ArrayList;
import java.util.List;

public class Lc1023med {
    public static void main(String[] args) {
        String[] x = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        System.out.println(camelMatch(x, "FB"));
    }
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> x = new ArrayList<>();
        int CamlChar = check(pattern);
//        String[] arr2 = pattern.split("(?=[A-Z])");
        for (int i = 0; i < queries.length; i++) {
            if(check(queries[i]) == CamlChar){
//                String[] arr1 = queries[i].split("(?=[A-Z])");
//                int j = 0;
//                while (j < CamlChar){
//                    if(isSubsequence(queries[j], pattern)){
//                        j++;
//                    }else break;
//                }
                if(isSubsequence(queries[i], pattern)){
                    x.add(true);
                }else x.add(false);
            }else x.add(false);
        }
        return x;
    }
    public static int check(String s){
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) <= 90 && s.charAt(i) >= 65){
                c++;
            }
        }
        return c;
    }
    public static boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == b.length();
    }
}
