class Solution {
    public String shortestPalindrome(String s) {
        if(s.contentEquals(new StringBuilder(s).reverse())){
            return s;
        }

        // int i = s.length()-1;

        // while(i > 0){
        //     Strring s = s + 2;
        // }

        // int i = s.length()-1;

        // while(i >= 0){
        //     String ss = (new StringBuilder(s.substring(i)).reverse()).toString() + s;
        //     if(ss.contentEquals(new StringBuilder(ss).reverse())){
        //         return ss;
        //     }
        //     i--;
        // }
        // // return s;


        // int last = -1;

        // for (int i = s.length()-1; i >= 0; i--) {
        //     if(s.substring(0, i+1).equals(new StringBuilder(s.substring(0, i+1)).reverse().toString())){
        //         last = i;
        //         break;
        //     }
        // }
        // return (new StringBuilder(s.substring(last+1)).reverse().toString() + s);


        String ss = s + "#" + (new StringBuilder(s).reverse()).toString();

        int[] x = new int[ss.length()];
        x[0] = 0;
        int i = 1, j = 0;
        while(i < ss.length()){
            if(ss.charAt(i) == ss.charAt(j)){
                x[i] = j + 1;
                i++;
                j++;
            }else{
                if(j == 0){
                    x[i] = 0;
                    i++;
                }else{
                j = x[j-1];
                }
            }
        }

        return (new StringBuilder(s.substring(x[x.length-1])).reverse().toString() + s);
    }
}