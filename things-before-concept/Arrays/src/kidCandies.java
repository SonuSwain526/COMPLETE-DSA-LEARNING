import java.util.ArrayList;
import java.util.Arrays;

public class kidCandies {
    public static void main(String[] args) {
        ArrayList<Boolean> x = new ArrayList<>();
        int[] candies = {1,2,3,4};
        int extraCandies = 1;
//        boolean[] x = new boolean[candies.length];
        int max = Maxx(candies);
        for(int i = 0; i < candies.length; i++){
            if((candies[i] + extraCandies) >= max){
                x.add(true);
            }
            else
                x.add(false);
//            x[i] = (candies[i] + extraCandies) >= max;
        }
        System.out.println(x);
    }

    public static int Maxx(int[] a){
        int max = 0;
        for (int j : a) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }
}
