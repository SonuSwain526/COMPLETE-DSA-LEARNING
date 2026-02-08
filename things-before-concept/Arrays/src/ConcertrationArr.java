import java.util.Arrays;

public class ConcertrationArr {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(Arrays.toString(ConArr(arr)));

    }
    static int[] ConArr(int[] arr){
        int[] ans = new int[arr.length*2];
            for (int i = 0; i <arr.length; i++) {
                ans[i] = arr[i];
                ans[i+arr.length] = arr[i];
        }
        return ans;
    }
}
