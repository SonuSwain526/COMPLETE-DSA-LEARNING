import java.util.ArrayList;
import java.util.Arrays;

public class ccc {
    public static void main(String[] args) {
        System.out.println(x(3));
    }
    public static ArrayList<Integer> x(int n){
        int res = 0;
        ArrayList<Integer> x = new ArrayList<>();
        int i = n;
        x.add(i);
        while(i != 1){
            if(i % 2 == 0){
                i = i / 2;
                x.add(i);
            }
            else {
                i = (i * 3) + 1;
                x.add(i);
            }
        }
        return x;
    }
}
