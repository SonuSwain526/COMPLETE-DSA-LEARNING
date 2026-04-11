import java.util.ArrayList;
import java.util.Arrays;

public class Lc1079 {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> anss = new ArrayList<>();
//        x("ABC", 0, new StringBuilder(), ans);
        for (String str : ans) {
            if (str.length() == 0) continue; // skip empty

//            xx(str, new StringBuilder(), result);
        }
//
//        System.out.println(result);
//        System.out.println("Total: " + result.size());
        System.out.println(anss);
    }
    public static int numTilePossibilities(String tiles) {
        return 4;
    }
    public static void x(String s, int ix,StringBuilder sb, ArrayList<String> temp){
        if(ix == s.length()){
            temp.add(sb.toString());
            return;
        }
        if(ix > s.length()) return;

        sb.append(s.charAt(ix));
        x(s, ix+1, sb, temp);
        sb.deleteCharAt(sb.length()-1);
        x(s, ix+1, sb, temp);
    }
    public static void xx(String s, int ix,StringBuilder sb, ArrayList<String> temp){
        if(sb.length() == s.length()){
            temp.add(sb.toString());
            return;
        }
        if(ix >= s.length() || sb.length() > s.length()) return;


        for (int i = 0; i < s.length(); i++) {
            boolean ch = false;
            for (int j = 0; j < sb.length(); j++) {
                if(s.charAt(i) == sb.charAt(j)) {
                    ch = true;break;
                }
            }
            if(!ch){
                sb.append(s.charAt(i));
                xx(s, i+1, sb, temp);
                sb.deleteCharAt(sb.length()-1);
            }

        }


    }
}
