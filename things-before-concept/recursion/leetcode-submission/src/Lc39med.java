import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lc39med {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7}, 7);
    }

    public static void fun(List<List<Integer>>ans,List<Integer> temp,int[] candidates,int idx,int sum,int target){
        if(sum > target) return;
        if(idx > candidates.length-1){
            if(sum == target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(candidates[idx]);
        fun(ans, temp, candidates, idx, sum + candidates[idx], target);

        temp.remove(temp.size()-1);
        fun(ans, temp, candidates, idx+1, sum, target);

        return;
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        fun(ans,temp,candidates,0,0,target);
        return ans;
    }
}
