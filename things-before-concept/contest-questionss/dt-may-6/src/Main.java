import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] x = {
                {'#', '.', '#'},
                {'.', '.', '.'}
        };
        char[][] c = rotateTheBox(x);
        System.out.println(Arrays.toString(c));
    }
    public static char[][] rotateTheBox(char[][] matrix) {
        int n = matrix.length;
        char[][] x = new char[matrix[0].length][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < x[0].length; i++) {
            int curPos = n-1;
            for (int j = n-1; j >= 0; j--) {
                if(matrix[j][i] == '#'){
                    x[j][i] = '.';
                    x[curPos][i] = '#';
                    curPos = curPos-1;
                }
                else if(matrix[j][i] == '*'){
                    curPos = j-1;
                }
            }
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.print(x[i][j]);
            }
            System.out.println();
        }
        return x;
    }
}