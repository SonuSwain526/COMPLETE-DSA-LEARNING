import java.util.Arrays;

public class dt_may_12_hard {
    public static void main(String[] args) {
        int[][] aa = {
                {1, 3},
                {2, 4},
                {10, 11},
                {10, 12},
                {8, 9}
        };
        Arrays.sort(aa, (a, b) ->
                (b[1] - b[0]) - (a[1] - a[0])
        );
        System.out.println(minimumEffort(aa));
    }
    public static int minimumEffort(int[][] tasks) {
        int min = 0;
        int max = 0;
        int n = tasks.length;
        for (int[] task : tasks) {
            min = Math.max(min, task[1]);
            max += task[1];
        }
        int an = -1;

        while (min <= max) {
            int mid = (max + min) / 2;
            int ans = x(mid, tasks);
            if (ans >= 0) {
                an = mid;
                max = mid - 1;
            } else{
                min = mid + 1;
            }
        }
        return an;
    }
    public static int x(int mid, int[][] a){
        for (int[] ints : a) {
            if(mid < ints[1]) return -1;
            mid -= ints[0];
        }

        return 1;
    }
}
