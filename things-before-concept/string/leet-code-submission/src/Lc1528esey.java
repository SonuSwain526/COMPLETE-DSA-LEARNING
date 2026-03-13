import java.util.Arrays;

public class Lc1528esey {
    public static void main(String[] args) {
        String x = "codeleet";
        int[] y = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString(x, y));

    }
    public static String restoreString(String s, int[] indices) {
        StringBuilder x = new StringBuilder();
        char[] ans = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[indices[i]] = s.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            x.append(ans[i]);
        }

        return x.toString();
    }
}
