public class Lc1750med {
    public static void main(String[] args) {
        System.out.println(minimumLength("aaaaaaaaaaaaa"));
    }
    public static int minimumLength(String s) {
        int i = 0, j= s.length()-1;

        while (i < j){
            if(s.charAt(i) == s.charAt(j)){
                if(s.charAt(i) == s.charAt(i+1) && s.charAt(j) != s.charAt(j-1)){
                    i++;
                } else if (s.charAt(j) == s.charAt(j-1) && s.charAt(i) != s.charAt(i+1)) {
                    j--;
                }else if (s.charAt(j) == s.charAt(j-1) && s.charAt(j) == s.charAt(i)) {
                    j--;
                    i++;
                }else if (s.charAt(j) != s.charAt(j-1) && s.charAt(i) != s.charAt(i+1)) {
                    j--;
                    i++;
                }
            }else return j - i + 1;
        }
        return j - i + 1;
    }
}
