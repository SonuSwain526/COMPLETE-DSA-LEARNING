import java.util.ArrayList;
import java.util.List;

public class Lc17med {
    public static void main(String[] args) {
        System.out.println(letterCombinations("899"));
        }
        public static List<String> letterCombinations(String digits) {
            int n = digits.length();
            List<String> x = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if(digits.charAt(i) == '2'){
                    x.add("abc");
                } else if (digits.charAt(i) == '3') {
                    x.add("def");
                } else if (digits.charAt(i) == '4') {
                    x.add("ghi");
                } else if (digits.charAt(i) == '5') {
                    x.add("jkl");
                } else if (digits.charAt(i) == '6') {
                    x.add("mno");
                } else if (digits.charAt(i) == '7') {
                    x.add("pqrs");
                } else if (digits.charAt(i) == '8') {
                    x.add("tuv");
                }else x.add("wxyz");
            }
            List<String> ans = new ArrayList<>();
            String str = x.getFirst();
            if(digits.length() == 1){
                for (int i = 0; i < str.length(); i++) {
                    ans.add(str.substring(i, i+1));
                }
                return ans;
            }

            x.removeFirst();
            for (int i = 0; i < str.length(); i++) {
                fun(x, 0, new StringBuilder(str.substring(i, i+1)), ans);
            }
            return ans;
        }

        public static void fun(List<String> ques, int ix,StringBuilder s, List<String> ans){
            if(s.length() == ques.size()+1){
                ans.add(s.toString());
                return;
            }if(ix >= ques.size()) return;

            for (int i = 0; i < ques.get(ix).length(); i++) {
                s.append(ques.get(ix).charAt(i));
                fun(ques, s.length()-1, s, ans);
                s.deleteCharAt(s.length()-1);
            }
        }
}
