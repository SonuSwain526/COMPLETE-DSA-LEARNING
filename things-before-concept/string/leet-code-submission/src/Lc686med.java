public class Lc686med {
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
    }
    public static int repeatedStringMatch(String a, String b) {
        StringBuilder x = new StringBuilder(a);
        int i = 1;
        if((a.chars().allMatch(c -> b.indexOf(c) != -1)) && check(a, b)){
            while (!(x.toString()).contains(b)){
                x.append(a);
                i++;
            }
        }else return -1;
        return i;
    }
    public static boolean check(String a, String b){
        int j = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(j)){
                j++;
            }
        }
        int x = j;
        if(j == 0) return false;
        else {
            for (int i = 0; i < x+1; i++) {
                if(a.charAt(i) == b.charAt((b.length()) - j)){
                    j--;
                }else return false;
            }
        }
        return true;
    }
}
