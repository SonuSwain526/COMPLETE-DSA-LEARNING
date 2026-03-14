public class Lc1638esey {
    public static void main(String[] args) {
        System.out.println(interpret("(al)G()()"));
    }
    public static String interpret(String c) {
        int ix = 0;
        StringBuilder x = new StringBuilder();
        while(ix<c.length()){
            if(c.charAt(ix) == '('){
                if(c.charAt((ix+1)) == 'a'){
                    x.append("al");
                    ix = ix+4;
                }else {
                    x.append("0");
                    ix = ix+2;
                }
            }else {
                x.append("G");
                ix++;
            }
        }
        return x.toString();
    }
}
