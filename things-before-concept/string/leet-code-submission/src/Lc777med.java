public class Lc777med {
    public static void main(String[] args) {
        System.out.println(canTransform("XXLRXX" , "XLXXRX"));
    }
    public static boolean canTransform(String s, String r) {

        if(!s.replace("X", "").equals(r.replace("X", ""))){return false;}

        int i = 0, j = 0;

        while(i < s.length() && j < s.length()){
            while(i < s.length() && s.charAt(i) == 'X'){ i++;}
            while(j < s.length() && r.charAt(j) == 'X'){ j++;}

            if(i == s.length() || j == r.length()) break;

            if(s.charAt(i) != r.charAt(j)) return false;

            if(s.charAt(i) == 'L' && i < j) return false;

            if(s.charAt(i) == 'R' && j < i) return false;

            i++;
            j++;
        }
        return true;
    }
}
