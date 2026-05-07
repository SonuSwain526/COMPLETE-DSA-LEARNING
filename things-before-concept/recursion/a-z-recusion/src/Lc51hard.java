import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc51hard {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        List<List<String>> ss = new ArrayList<>();
        boolean[][] b = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            nqn(s, 0, i, b);
            ss.add(s);
        }
        System.out.println(ss);
    }
    public static void nqn(List<String> s, int i,int j, boolean[][] b){
        StringBuilder bb = new StringBuilder();
        for (int k = 0; k < b[0].length; k++) {
            if(k == j){
                bb.append("Q");
            }else bb.append("X");
        }
        s.add(bb.toString());
        int n = b.length;
        int m = b[0].length;

// column ↓
        for(int r = i; r < n; r++) b[r][j] = true;

// column ↑
        for(int r = i; r >= 0; r--) b[r][j] = true;

// row →
        for(int c = j; c < m; c++) b[i][c] = true;

// row ←
        for(int c = j; c >= 0; c--) b[i][c] = true;

// diagonal ↘
        for(int r = i, c = j; r < n && c < m; r++, c++) b[r][c] = true;

// diagonal ↖
        for(int r = i, c = j; r >= 0 && c >= 0; r--, c--) b[r][c] = true;

// diagonal ↙
        for(int r = i, c = j; r < n && c >= 0; r++, c--) b[r][c] = true;

// diagonal ↗
        for(int r = i, c = j; r >= 0 && c < m; r--, c++) b[r][c] = true;
        for(boolean[] x: b){
            System.out.println(Arrays.toString(x));
        }
        for (int z = 0; z < b[0].length; z++) {
            if(
                    (i+2 >= b.length || !b[i+2][z]) &&
                            (i < 0 || !b[i][z]) &&
                            (m+1 >= b[0].length || !b[i+1][z+1]) &&
                            (m-1 < 0 || !b[i+1][z-1]) &&

                            (i+2 >= b.length || z+1 >= b[0].length || !b[i+2][z+1]) &&
                            (i+2 >= b.length || z-1 < 0 || !b[i+2][z-1]) &&
                            (i < 0 || z+1 >= b[0].length || !b[i][z+1]) &&
                            (i < 0 || z-1 < 0 || !b[i][z-1])
            ){
                nqn(s, i+1, z, b);
                s.removeLast();
            }
        }

//        int n = b.length;
//        int m = b[0].length;

// column ↓
        for(int r = i; r < n; r++) b[r][j] = false;

// column ↑
        for(int r = i; r >= 0; r--) b[r][j] = false;

// row →
        for(int c = j; c < m; c++) b[i][c] = false;

// row ←
        for(int c = j; c >= 0; c--) b[i][c] = false;

// diagonal ↘
        for(int r = i, c = j; r < n && c < m; r++, c++) b[r][c] = false;

// diagonal ↖
        for(int r = i, c = j; r >= 0 && c >= 0; r--, c--) b[r][c] = false;

// diagonal ↙
        for(int r = i, c = j; r < n && c >= 0; r++, c--) b[r][c] = false;

// diagonal ↗
        for(int r = i, c = j; r >= 0 && c < m; r--, c++) b[r][c] = false;
    }
}
