public class Lc848med {
    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[]{1,2,25}));
    }
    public static String shiftingLetters(String s, int[] shifts) {
        StringBuilder x = new StringBuilder(s);
        for (int i = s.length()-1; i >= 0; i--) {
            x = place(x, shifts[i], i);
        }

        return x.toString();
    }
    public static StringBuilder place(StringBuilder x, int v, int ix){
        for (int i = 0; i <= ix; i++) {
            x.setCharAt(i, (char)((x.charAt(i)  + v)%26));
        }
        return x;
    }
}
