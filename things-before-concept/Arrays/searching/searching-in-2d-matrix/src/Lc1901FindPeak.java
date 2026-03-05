import java.util.Arrays;

public class Lc1901FindPeak {
    public static void main(String[] args) {
        int[][] x = {
                {-1,-1,-1,-1,-1},
                {-1,1,2,3,4,-1},
                {-1,5,6,7,8,-1},
                {-1,9,10,11,12,-1},
                {-1,-1,-1,-1,-1}
        };
        System.out.println(Arrays.toString(findPeakGrid(x)));
    }
    public static int[] findPeakGrid(int[][] mat) {        int sRow = 0, eRow = mat.length - 1;
        int col = mat[0].length-1;
        int midClm = col /2;
        int midRow = eRow / 2;

        while((midRow <= mat.length && midRow >= 0) && (midClm >= 0 && midClm <= mat[0].length)){
            int left  = (midClm - 1 < 0) ? -1 : mat[midRow][midClm - 1];
            int right = (midClm + 1 >= mat[0].length) ? -1 : mat[midRow][midClm + 1];

            int up    = (midRow - 1 < 0) ? -1 : mat[midRow - 1][midClm];
            int down  = (midRow + 1 >= mat.length) ? -1 : mat[midRow + 1][midClm];
            int cur   = mat[midRow][midClm];

            int largest = largcheck(left, right, up, down, cur);

            if (largest == cur) {
                return new int[]{midRow, midClm};
            }
            if (largest == left) {
                midClm--;
            }
            if (largest == right) {
                midClm++;
            }
            if (largest == up) {
                midRow--;
            }
            if (largest == down) {
                midRow++;
            }
        }
        return new int[]{0};
    }
    public static int largcheck(int a, int b, int c, int d, int e){
        int x = Math.max(a,b);

        int y = Math.max(c, d);
        return Math.max(e,Math.max(x, y));
    }
}
