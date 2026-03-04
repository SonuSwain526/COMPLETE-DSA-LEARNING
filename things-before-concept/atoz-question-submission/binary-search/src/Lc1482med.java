import java.util.Arrays;

public class Lc1482med {
    public static void main(String[] args) {
        int[] b = {7,7,7,7,12,7,7};
        System.out.println(minDays(b, 2, 3));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        boolean[] days = new boolean[bloomDay.length];

        int s = Integer.MAX_VALUE, e = 0;
        for(int x: bloomDay){
            s = Math.min(s, x);
            e = Math.max(e, x);
        }
        int midD = -1;
        while (s<e){
            Arrays.fill(days, false);
            int mid = (s+e)/2;
            for (int i = 0; i < bloomDay.length; i++) {
                if(bloomDay[i] <= mid){
                    days[i] = true;
                }
            }
            int x = 0;int ex = 0;
            for (boolean day : days) {
                if (day) {
                    x++;
                }
                if (x == k) {
                    ex++;
                    x = 0;
                } else
                    x = 0;
            }
            if(x < m){
                s = mid+1;
            } else{
                e = mid;
            }

        }
        return e;

    }
}
