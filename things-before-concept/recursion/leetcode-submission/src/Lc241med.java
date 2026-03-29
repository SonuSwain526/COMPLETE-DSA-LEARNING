import java.util.ArrayList;
import java.util.List;

public class Lc241med {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }
    public static List<Integer> diffWaysToCompute(String expression) {
        return x(expression);
    }

    public static List<Integer> x(String s){
        if(s.length() <= 2 && !s.isEmpty()){
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(s));
            return list;
        }
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '+' ||c == '-' ||c == '*'){
                List<Integer> lf = x(s.substring(0, i));
                List<Integer> rh = x(s.substring(i+1));


                for(int a: lf){
                    for(int b: rh){
                        if(c == '+') {
                            ans.add( a + b);
//                    return ans;
                        }
                        else if(c == '-') {
                            ans.add(a-b);
//                    return ans;
                        }else  {
                            ans.add(a * b);
//                    return ans;
                        }
                    }
                }


            }
        }
        return ans;
    }
}
