import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class Lc49med {
    public static void main(String[] args) {
        int x = 'a';
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
//        System.out.println(calc("ddd"));
        System.out.println(groupAnagrams(arr));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> x = new ArrayList<>();
        ArrayList<String> oneD = new ArrayList<>();

        String[] y = new String[strs.length];

        calc(strs, y);

        sortByAsciiSum(strs);
        sortByAsciiSum(y);

        int ix = 0;

        oneD.add(strs[ix]);

        for (int i = ix+1; i < strs.length; i++) {

            if(y[ix].equals(y[i])){
                oneD.add(strs[i]);
            }
            else {
                x.add(oneD);
                oneD = new ArrayList<>();
                ix = i;
                oneD.add(strs[ix]);
            }
        }

        x.add(oneD);
        return x;
    }
    public static void calc(String[] y, String[] x){
        int sum = 0;
        for (int i = 0; i < y.length; i++) {
            char[] ch = y[i].toCharArray();   // convert to char array
            Arrays.sort(ch);
            String sorted = new String(ch);
            x[i] = sorted;
        }
    }

    public static int asciiSum(String s){
        int sum = 0;
        for(char c : s.toCharArray()){
            sum += c;
        }
        return sum;
    }

    public static void sortByAsciiSum(String[] arr){
        Arrays.sort(arr, (a,b) -> asciiSum(a) - asciiSum(b));
    }


//    public static void bs(String[] y,List<List<String>> z, int t){
//        ArrayList<String> oneD = new ArrayList<String>();

//        int s = start;
//        int e = x.length-1;
//        while (s < e){
//            int mid = s + (e-s)/2;
//            if(x[t] == x[mid]){
//                s = mid;
//                if(s + 1 == e){
//                    s = mid+1;
//                }
//            }else if (x[mid] < x[t]){
//                s = mid;
//            }else e = mid-1;
//        }
//        oneD.add(y[t]);
//        if(s != -1) {
//            for (int j = start+1; j <= s; j++) {
//                if(y[j].length() == y[start].length()){
//                    oneD.add(y[j]);
//                }
//            }
//        }
////
////        int ss = 0;
////        while (ss < y.length){
////            if(x[ss] == x[ss+1]){
////
////            }
////        }
//
//        z.add(oneD);
////
////        if(x[s] == t) return s;
////        else return -1;
//    }
}
