import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc56med {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 5},
                {1, 2},
                {4, 7},
                {3, 9}
        };
//        System.out.println(merge(arr));
    }
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> x = new ArrayList<>();
        // for(int[] z: intervals){
        //     System.out.println(Arrays.toString(z));
        // }
        int curR = 0;
        int curC = 0;
        int curMin = intervals[0][0];
        int curMax = intervals[0][1];
        while (curR < intervals.length-1){
            if(curMin < intervals[curR + 1][curC] && curMax < intervals[curR + 1][curC]){
                x.add(new int[]{curMin, curMax});
                curMin = intervals[curR+1][curC];
                curMax = intervals[curR+1][curC+1];
            }else{
                curMin = Math.min(curMin, intervals[curR+1][curC]);
                curMax = Math.max(curMax, intervals[curR+1][curC + 1]);
            }
            curR++;
        }
        x.add(new int[]{curMin, curMax});

        //     int[][] arr = new int[x.size()][];

        // for(int i = 0; i < x.size(); i++){
        //     arr[i] = new int[x.get(i).size()];
        // for(int j = 0; j < x.get(i).size(); j++){
        //     arr[i][j] = x.get(i).get(j);
        // }
        // }

        return x.toArray(new int[x.size()][]);
    }
}
