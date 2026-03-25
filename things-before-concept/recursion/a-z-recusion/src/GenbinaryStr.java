import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenbinaryStr {
    public static void main(String[] args) {
        StringBuilder x = new StringBuilder();
        ArrayList<String> ar = new ArrayList<>();
        generateBinaryStringss(3, ar,  x);
        System.out.println(ar);
    }
//    public static List<String> generateBinaryStrings(int n) {
//        // Your code goes here
//
//    }

    public static void generateBinaryStringss(int n, List<String> x, StringBuilder cur) {

        if(n == cur.length()){
            x.add(cur.toString());
            return;
        }
        if(n < cur.length()) return;
        if(cur.isEmpty() || cur.charAt(cur.length()-1) == '0'){
            generateBinaryStringss(n, x, cur.append('0'));
            cur.deleteCharAt(cur.length()-1);
            generateBinaryStringss(n, x, cur.append('1'));
            cur.deleteCharAt(cur.length()-1);
        }
        else{
            generateBinaryStringss(n, x, cur.append('0'));
            cur.deleteCharAt(cur.length()-1);
        }
        return;
    }
}
