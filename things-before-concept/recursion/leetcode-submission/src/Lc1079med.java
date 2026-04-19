import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TransferQueue;

public class Lc1079med {
    public static void main(String[] args) {



        List<String> s = new ArrayList<>();
        List<String> ss = new ArrayList<>();
        boolean[] bact = new boolean[3];
        x(0, new StringBuilder(), s, "CDC");
        s.removeLast();
        boolean t = false;
//        Arrays.fill(bact, true);
        System.out.println(Arrays.toString(bact));
//        for (int i = 0; i < s.size(); i++) {
////            for (int j = i-1; j >=0; j--) {
////                if(ss.contains(s.get(i))) {
////                    t = true;
////                }
////            }
//            if(ss.contains(s.get(i))) {
//                t = true;
//            }
//            if(!t)
//                secondlevel(new StringBuilder(), ss, s.get(i), bact);
//            t = false;
//        }
        secondlevel(new StringBuilder(), ss, "CDC", bact);
        System.out.println(s);
        System.out.println(ss);
    }
//    public static int numTilePossibilities(String tiles) {
//
//    }
    public static void x(int ix, StringBuilder st, List<String> s, String t){
        if(ix >= t.length()){
            s.add(st.toString());
            return;
        }

        x(ix+1, st.append(t.charAt(ix)), s, t);
        st.delete(st.length()-1, st.length());
        x(ix+1, st, s, t);

    }
    public static void secondlevel(StringBuilder st, List<String> s, String t, boolean[] bact) {
        if (st.length() == t.length()) {
            s.add(st.toString());
            return;
        }

        for (int i = 0; i < t.length(); i++) {
            if (bact[i]) continue;

            // 2. The Duplicate Skip Logic
            if (i > 0 && t.charAt(i) == t.charAt(i - 1) && !bact[i - 1]) {
                continue;
            }

            bact[i] = true;
            st.append(t.charAt(i));

            secondlevel(st, s, t, bact);

            // 3. Backtrack
            bact[i] = false;
            st.deleteCharAt(st.length() - 1);
        }
    }
}
