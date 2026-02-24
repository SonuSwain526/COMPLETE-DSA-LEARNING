import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Maxsubsequences {
    public static void main(String[] args) {
        int[] x = {1,0,1,1,1};
        int count = 0;
        int max = 0;
        for(int a: x){
            if(a == 1){
                count++;
                max = Math.max(max, count);
            }
            else {
                count = 0;
            }
        }
        System.out.println(max);
    }
}
