import java.util.Arrays;

public class Lc1886esey {
    public static void main(String[] args) {

    }
    public static boolean findRotation(int[][] mat, int[][] target) {
        return findRotation(mat, target);
    }
    public boolean findRotation(int[][] mat, int[][] target, int x) {
        if(x == 4)return false;
        int[][] ra = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                ra[i][j] = mat[mat.length - j - 1][i];
            }
        }
        if(Arrays.deepEquals(ra, target)){
            return true;
        }
        return findRotation(ra, target, x+1);
    }
}
