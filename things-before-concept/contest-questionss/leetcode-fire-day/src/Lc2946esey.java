import java.util.Arrays;

public class Lc2946esey {
    public static void main(String[] args) {
        int[][] x = {
                {3,10,3,10,3,10,3,10},
                {5,8,5,8,5,8,5,8},
                {3,9,3,9,3,9,3,9},
                {3,8,3,8,3,8,3,8},
                {2,3,2,3,2,3,2,3}
        };
        System.out.println(areSimilar(x, 2));
    }
    public static boolean areSimilar(int[][] mat, int k) {
        int[][] copy = new int[mat.length][mat[0].length];
        int[][] copy1 = new int[mat.length][mat[0].length];
         for(int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, copy[i], 0, mat[0].length);
        }
        for(int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, copy1[i], 0, mat[0].length);
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < mat.length; j = j+2) {
                int temp = mat[j][0];
                for (int l = 0; l < mat[0].length-1; l++) {
                    mat[j][l] = copy[j][l+1];
                }
                mat[j][mat[0].length-1] = temp;
            }

            for (int j = 1; j < mat.length; j = j+2) {
                int temp = mat[j][mat[0].length-1];
                for (int l = 0; l < mat[0].length-1; l++) {
                    mat[j][l+1] = copy[j][l];
                }
                mat[j][0] = temp;
            }
            for(int m = 0; m < mat.length; m++) {
                System.arraycopy(mat[m], 0, copy[m], 0, mat[0].length);
            }
        }
        for(int[] x: mat){
            System.out.println(Arrays.toString(x));
        }
        return Arrays.deepEquals(mat, copy1);

    }
}
