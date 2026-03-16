import java.util.ArrayList;
import java.util.List;

public class Lc1324med {
    public static void main(String[] args) {
        System.out.println(printVertically("HOW ARE YOU"));
    }
    public static List<String> printVertically(String s) {
        List<String> x = new ArrayList<>();
        boolean ex = true;
        int i = 0;
        int ix = 0;
        while (ix < s.length()){
            if(s.charAt(ix) != ' '){
                if(i < x.size() || x.isEmpty()|| ex) {
                    if (ex) x.add(i, String.valueOf(s.charAt(ix)));
                    else x.set(i, x.get(i) + s.charAt(ix));
                    i++;
                }
                else {
                    x.add(i, String.valueOf(s.charAt(ix)));
                }

            }else {i = 0; ex = false;}
            ix++;
        }
        return x;
    }
}
