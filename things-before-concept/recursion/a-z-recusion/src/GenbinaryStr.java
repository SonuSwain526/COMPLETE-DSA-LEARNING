import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenbinaryStr {
    public static void main(String[] args) {
        StringBuilder x = new StringBuilder();
        x.append("0".repeat(4));
        System.out.println(generateBinaryStringss(4, new ArrayList<String>(Collections.singleton(x.toString())), 0, x));
    }
//    public static List<String> generateBinaryStrings(int n) {
//        // Your code goes here
//
//    }

    public static List<String> generateBinaryStringss(int n, List<String> x, int ix, StringBuilder cur) {
        if(ix >= n || cur.charAt(ix) == '1')return x;

        if(ix == n-1 && '1' != cur.charAt(ix-1)){
            cur.setCharAt(ix, '1');
            x.add(cur.toString());
        }
        else if(ix == 0 && 1 != cur.charAt(ix+1)){
            cur.setCharAt(ix, '1');
            x.add(cur.toString());
        }
        else if((ix < n-1 && ix > 0) && ('1' != cur.charAt(ix+1) && '1' != cur.charAt(ix-1))){
            cur.setCharAt(ix, '1');
            x.add(cur.toString());
        }
        generateBinaryStringss(n, x, ix+1, cur);
        generateBinaryStringss(n, x, ix + 1, new StringBuilder(x.getFirst()));
        return x;
    }
}
