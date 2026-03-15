import java.util.Arrays;
import java.util.List;

public class L539med {
    public static void main(String[] args) {
        List<String> x= List.of(new String[]{"00:00","23:59","00:00"});
        System.out.println(findMinDifference(x));
    }
    public static int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        int[] arr = new int[timePoints.size()];
        int[] arr2 = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            if(timePoints.get(i).equals("00:00")){
                arr[i] = 24*60;
                arr2[i] = 0;
            }else{
                arr[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3, 5));
                arr2[i] = arr[i];
            }
        }

        Arrays.sort(arr);

         for (int i = 0; i < timePoints.size()-1; i++) {
             min = Math.min(min, Math.abs(arr[i] - arr[i+1]));
             min = Math.min(min, Math.abs(arr2[i] - arr2[i+1]));
         }
        return min;
    }
}
