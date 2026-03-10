import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Lc349esey {
    public static void main(String[] args) {
        int[] x = {4,9,5};
        int[] y= {9,4,9,8,4};

        intersection(x,y);
    }
    public static void intersection(int[] n1, int[] n2) {
        Arrays.sort(n1);
        Arrays.sort(n2);

        ArrayList<Integer> x = new ArrayList<>();

        int n1Right = n1.length-1;
        int n2Right = n2.length-1;
        int prx = Integer.MIN_VALUE;
        int pry = Integer.MIN_VALUE;

        while (n1Right >= 0 && n2Right >= 0){
            if(n1[n1Right] == prx && n2[n2Right] == pry){
                n1Right--;
                n2Right--;
            }else{
            if(n1[n1Right] == n2[n2Right]){
                x.add(n1[n1Right]);
                prx = n1[n1Right];
                pry = n2[n2Right];
                n1Right--;
                n2Right--;
            }else if(n1[n1Right] < n2[n2Right]){
                n2Right--;
            }else {
                n1Right--;
            }
            }
        }
        System.out.println(x);
    }
}
