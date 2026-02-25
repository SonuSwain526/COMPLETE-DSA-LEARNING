import java.util.ArrayList;

public class SubarrSum {
    public static void main(String[] args) {
        // code here
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] arr = {12, 18, 5, 11, 30, 5};
        int target = 3;
        System.out.println(summ(arr, target));
    }
    public static ArrayList<Integer> summ(int[] arr, int target){
        ArrayList<Integer> x = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            int sum = 0;

            for(int j = i; j<arr.length; j++){
                sum = sum + arr[j];
                if(sum == target){
                    x.add(i+1);
                    x.add(j+1);
//                    System.out.println(x);
                    return x;

                }
//                else {
//                    sum = sum + arr[j];
//                    System.out.println(sum);
//                }
            }
        }
        x.add(-1);
        return x;
    }
}
