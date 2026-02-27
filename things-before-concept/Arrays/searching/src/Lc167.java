import java.util.Arrays;

public class Lc167 {
    public static void main(String[] args) {
        int[] x = {2,7,11,15};
//        int target = 9;
//        int start = 0, end = x.length-2;
        System.out.println(Arrays.toString(twoSum(x, 18)));
    }
    public static int[] twoSum(int[] x, int target) {
        int i = 0, j = x.length-1;
        while(i<j){
            if(( x[i]+x[j] )== target){
                return new int[] {i,j};
            } else if (( x[i]+x[j] ) < target) {
                i++;
            }
            else
                j--;
        }
    return new int[] {-1,-1};
    }
}
