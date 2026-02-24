import java.util.ArrayList;
import java.util.Arrays;

public class PascleTriangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int numRows = 0;
        for (int i = 0; i < numRows; i++) {

            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if(j == 0 || i == j){
                    row.add(j,1);
                }
                else
                    row.add(j, matrix.get(i-1).get(j) + matrix.get(i-1).get(j-1));
            }

            matrix.add(row);
        }
            System.out.println(matrix);
            System.out.println();
    }
}
