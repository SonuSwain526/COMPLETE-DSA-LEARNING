import java.util.Arrays;

public class Bsinmax1 {
    public static void main(String[] args) {
        int[][] x = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(Arrays.toString(bs(x, 9)));
    }
    public static int[] bs(int[][] x, int t){
        int clm = x[0].length-1;
        int row = 0;
        while (clm >= 0 && row < x.length){
            if(x[row][clm] == t){
                return new int[]{row, clm};
            } else if (x[row][clm] < t) {
                row++;
            }else clm--;
        }
        return new int[]{-1,-1};
    }
}
