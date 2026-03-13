public class Lc1573med {
    public static void main(String[] args) {
        System.out.println(numWays("10101"));
    }
    public static int numWays(String s) {
        int n = s.length();
        int i = 1;
        int j = n - 1;
        int c = 0;

        while (i < j) {

            if (countone(s.substring(0, i)) == countone(s.substring(i, j)) &&
                    countone(s.substring(i, j)) == countone(s.substring(j, n))) {

                c++;
            }

            j--;

            if (j <= i) {
                i++;
                j = n - 1;
            }
        }
    return c;
    }
    public static int countone(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '1') count++;
        }
        return count;
    }
}
