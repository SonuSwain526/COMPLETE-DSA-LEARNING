public class Lc838 {
    public static void main(String[] args) {

    }
    public static String pushDominoes(String dominoes) {
        StringBuilder ss = new StringBuilder(dominoes);
        int n = dominoes.length();
        int i = 0;
        boolean[] b = new boolean[n];
        while(i < n){
            if(dominoes.charAt(i) == 'R'){
                int j = i;
                int c= 0;
                while(dominoes.charAt(j) != 'L'){
                    c++;
                    j++;
                    b[j] = true;
                }
                String x = "L";
                ss.replace(i, (c + i + 1)/2+1, String.valueOf(x).repeat(Math.max(0, c/2)));
                x = "R";
                if(c % 2 == 0){
                    ss.replace((c + i + 1)/2, n, String.valueOf(x).repeat(Math.max(0, c/2)));
                }else ss.replace((c + i + 1)/2 + 1, n, String.valueOf(x).repeat(Math.max(0, c/2)));
                i = j+1;
            }
            i++;
        }
        i = 0;
        while (i < n){
            if(!b[i] && dominoes.charAt(i) == 'L'){
                int j = i;
                while (!b[j] && j >= 0){
                    j--;
                }
//                ss.replace()
            }
        }
        return "";
    }
    public static String func(int c, String x){
        StringBuilder s = new StringBuilder();
        s.append(String.valueOf(x).repeat(Math.max(0, c)));
        return s.toString();
    }
}
