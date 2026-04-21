import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Lc79med {
    static boolean bb = false;
    public static void main(String[] args) {
        char[][] c = {
                {'a','b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a','d', 'e', 'f'}
        };
        boolean[][] b = new boolean[c.length][c[0].length];

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                bb = false;
                if(c[i][j] == 'a'){
                    boolean r = x("abcced", c, b, i, j, 1);
                    if(r) break;
                    System.out.println(r);
                }
            }
        }


    }
//    public static boolean exist(char[][] board, String word) {
//
//    }
    public static boolean x(String t, char[][] c, boolean[][] b, int i, int j, int ix){
        if(ix == t.length()){
            bb = true;
            return true;
        }
        b[i][j] = true;
        char ch = t.charAt(ix);

        if(i-1 >= 0 && ch == c[i-1][j] && !b[i-1][j]){
            x(t, c, b, i-1, j, ix+1);
        }
        if(j-1 >= 0 && ch == c[i][j-1] && !b[i][j-1]){
            x(t, c, b, i, j-1, ix+1);
        }
        if(i+1 < c.length && ch == c[i+1][j] && !b[i+1][j]){
            x(t, c, b, i+1, j, ix+1);
        }
        if(j+1 < c[0].length && ch == c[i][j+1] && !b[i][j+1]){
            x(t, c, b, i, j+1, ix+1);
        }
        b[i][j] = false;

        return bb;
    }
}
