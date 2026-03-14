public class Lc1668esey {
    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
    }
    public static int maxRepeating(String s, String w) {
        int wL = w.length();
        int sL = s.length();
        int c = 0;
        int ix = 0;
        while (ix < sL - wL){
            if(s.substring(ix, ix+wL).equals(w)){
                c++;
            }
            ix = ix+wL;
        }
        return c;
    }
}
