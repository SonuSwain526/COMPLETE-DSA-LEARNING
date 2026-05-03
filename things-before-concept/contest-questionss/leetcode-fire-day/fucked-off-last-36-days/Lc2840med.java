public class Lc2840med {
    public static void main(String[] args) {
        System.out.println(checkStrings("abe", "bea"));
    }
    public static boolean checkStrings(String s1, String s2) {
        if(s1.equals(s2)) return true;

        char[] s1a = s1.toCharArray();
        char[] s2a = s2.toCharArray();

        for (int i = 0; i < s2a.length; i++) {
            if(s1a[i] == s2a[i]) continue;
            boolean x = false;
            for (int j = i + 2; j < s2.length(); j = j+2) {
                if(s2a[i] == s1a[j]) {
                    x = true;
                    char temp = s1a[i];
                    s1a[i] = s1a[j];
                    s1a[j] = temp;
                    break;
                }
            }
            if(!x) return false;
        }
        return true;
    }
}
