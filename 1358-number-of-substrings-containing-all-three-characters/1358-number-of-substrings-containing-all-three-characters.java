class Solution {
    public int numberOfSubstrings(String s) {
        int A = 0;
        int B = 0;
        int C = 0;
        int n = s.length();

        int j = 0;
        int total = 0;
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == 'a') A++; else if(c == 'b') B++; else if(c == 'c') C++;
            if (A > 0 && B > 0 && C > 0){
//                if(i == n-1) total++;
//                else
                    total += n - i;
                while ( j < n ){
                    if (!(A > 0 && B > 0 && C > 0)){
                        break;
                    }
                    char ch = s.charAt(j);
                    if(ch == 'a') A--; else if(ch == 'b') B--; else if(ch == 'c') C--;
                    j++;
                    if (A > 0 && B > 0 && C > 0)
                        total += n - i;
                }
            }
        }
        return total;
    }
}