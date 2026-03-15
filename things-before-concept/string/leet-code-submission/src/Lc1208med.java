import java.util.Arrays;

public class Lc1208med {
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "acde", 0));
    }
    public static int equalSubstring(String s1, String s2, int maxCost) {

        int n = s1.length();
        int i = 0, j = 0;
        int chars = 0;
        int remainC = maxCost;
        while (i < n && j < n){
            int curCost = Math.abs(s1.charAt(i) - s2.charAt(j));
            if(curCost <= maxCost){
                int a = i, b = j, c= 0;
                while ((a < n && b < n) && curCost <= remainC){
                    a++;
                    b++;
                    if(a < n && b < n) curCost = Math.abs(s1.charAt(a) - s2.charAt(b));
                    remainC -= curCost;
                    c++;
                }
                remainC = maxCost;
                chars = Math.max(chars, c);
            }
            i++;
            j++;
        }


        return chars;
    }
}
