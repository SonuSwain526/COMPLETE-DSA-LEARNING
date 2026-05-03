import java.util.ArrayList;
import java.util.List;

public class Lc2452med {
    public static void main(String[] args) {

    }
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < dictionary.length; j++) {
                String cur = queries[i];
                String curD = dictionary[i];
                int c = 0;
                boolean x = false;
                for (int k = 0; k < cur.length(); k++) {
                    if (cur.charAt(k) != curD.charAt(k)) c++;
                    if(c > 2) {x = true; break;}
                }
                if(!x){
                    s.add(cur);
                }
            }
        }
        return s;
    }
}
