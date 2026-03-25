import java.util.ArrayList;
import java.util.List;

public class Lc22med {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> x = new ArrayList<>();
        x(0,0,new StringBuilder(), n, x);
        return x;
    }
    public static void x(int o, int c, StringBuilder x, int n, List<String> s){
        if(o == n&&c == n){
            s.add(x.toString());
            return;
        } else if (c > n || o > n) {
            return;
        } else if (c <= o || x.isEmpty()) {

            x(o+1, c, x.append("("), n, s);
            x.deleteCharAt(x.length()-1);
            x(o, c+1, x.append(")"), n, s);
            x.deleteCharAt(x.length()-1);
        } else {
            x(o, c+1, x.append(")"), n, s);
            x.deleteCharAt(x.length()-1);
//
        }
    }
}
