import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Code360PaingerAllocation {
    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(2);
        x.add(1);
        x.add(5);
        x.add(6);
        x.add(2);
        x.add(3);
        System.out.println(x);
        System.out.println(findLargestMinDistance(x, 2));
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int s = Collections.min(boards);
        int e = 0;
        for (int num : boards) {
            e += num;
        }

        while (s<e){
            int mid = s + (e - s)/2;
            if(check(boards, k, mid)){
                s = mid + 1;
            }else
                e = mid-1;
        }
    return s;
    }
    public static boolean check(ArrayList<Integer> x, int k, int mid){
        int painter =  0;
        int curSum = 0;
        for (Integer integer : x) {
            if (integer + curSum >= mid) {
                painter++;
                curSum = 0;
            } else curSum += integer;
            if (painter >= mid) {
                return true;
            }
        }
        return false;
    }
}
