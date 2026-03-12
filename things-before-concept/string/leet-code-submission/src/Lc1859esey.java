import java.util.Arrays;

public class Lc1859esey {
    public static void main(String[] args) {
        sortSentence("hii2 thre1");

    }
    public static void sortSentence(String s) {
        StringBuilder ans = new StringBuilder();
        String[] x = s.split(" ");
        int i = 0;
        while (i < x.length) {
            char curchar = x[i].charAt((x[i].length()-1));
            int num = curchar - '0';
            if(num != i+1){
                swap(x, i, num);
            }else i++;
        }

        for (int j = 0; j < x.length; j++) {
            x[j] = x[j].substring(0, x[j].length() - 1);
            ans.append(x[j]);
        }

        System.out.println(ans.toString());
    }
    public static void swap(String[] x,int i, int num){
        String temp = x[i];
        x[i] = x[num-1];
        x[num-1] = temp;
    }
}
