import java.util.Arrays;

public class BsinMatrixtype {
    public static void main(String[] args) {
        int[][] x = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int[][] y = {{1,2}};
        System.out.println(Arrays.toString(searchMatrix(y, 6)));
    }
    public static int[] searchMatrix(int[][] matrix, int target) {
        int sRow = 0;
        int eRow = matrix.length-1;
        int col = matrix[0].length;
        int clMid = col/2;

        while (sRow < eRow - 1){
            int rMid = sRow + (eRow - sRow)/2;
            if(matrix[rMid][clMid] == target){
                return new int[]{rMid, clMid};
            } else if ((matrix[rMid][clMid] < target) ){
                sRow = rMid;
            }else eRow = rMid;
        }

        if(matrix[sRow][clMid] == target){
            return new int[]{sRow, clMid};
        }if(matrix[sRow + 1][clMid] == target){
            return new int[]{sRow+1, clMid};
        }if(matrix[sRow][clMid] > target){
            return bs(matrix, sRow, 0, clMid - 1, target);
        }if(matrix[sRow][clMid] < target && (matrix[sRow][col-1] >= target)){
            return bs(matrix, sRow, clMid + 1, col-1, target);
        }if(matrix[sRow + 1][clMid] > target && (matrix[sRow+1][0] <= target)){
            return bs(matrix, sRow+1, 0, clMid - 1, target);
        }if(matrix[sRow + 1][clMid] < target){
            return bs(matrix, sRow+1, clMid, col-1, target);
        }
        return new int[]{-1,-1};
    }

    public static int[] bs(int[][] x, int sRow, int sCol, int eCol, int target){
        while (sCol <= eCol){
            int mid = sCol + (eCol - sCol)/2;
            if(x[sRow][mid] == target){
                return new int[]{sRow, mid};
            } else if (x[sRow][mid] < target) {
                sCol = mid+1;
            }else eCol = mid - 1;
        }
        return new int[]{-1, -1};
    }
}
