public class dt_may_4 {
    public static void main(String[] args) {
        String s = "defdefdefabcabc";
        String goal = "defdefabcabcdef";
        int ll = 0;
        int ix = 0;
        while(s.charAt(ix) == goal.charAt(ix)){
            ll = ix;
            ix++;
        }

        String xx = s.substring(ll+1) + s.substring(0, ll+1);
        System.out.println(xx);

        System.out.print(ll);
        int x = s.substring(ll).indexOf(goal.charAt(ll+1));
        System.out.print(x);
        String st = s.substring(x+ll) + s.substring(0, ll+x);
        System.out.println(st.equals(goal));
    }
}
