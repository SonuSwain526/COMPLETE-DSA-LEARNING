import java.util.Arrays;

public class Lc179med {
    public static void main(String[] args) {
        Integer[] nums = {3,30,34,5,9};
        Integer[] x = new Integer[nums.length];

        Arrays.sort(nums, (a, b) -> compareLeft(a, b));
        StringBuilder sb = new StringBuilder();

        for(int num : nums){
            sb.append(num);
        }
        System.out.println(sb.toString());
        System.out.println(Arrays.toString(nums));
    }



    static int compareLeft(int a, int b){

        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);

        int n = Math.min(s1.length(), s2.length());

        for(int i = 0; i < n; i++){

            if(s1.charAt(i) > s2.charAt(i)) return -1;
            if(s1.charAt(i) < s2.charAt(i)) return 1;
        }

        return s1.length() - s2.length();
    }

}
