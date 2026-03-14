public class Lc1616med {
    public static void main(String[] args) {
//        System.out.println(c("ulacfd", "jizalu"));
    }

    boolean check(String a, String b) {
        int l = 0;
        int r = a.length() - 1;

        while (l < r && a.charAt(l) == b.charAt(r)) {
            l++;
            r--;
        }

        return isPalindrome(a, l, r) || isPalindrome(b, l, r);
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
