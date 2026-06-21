class Solution {
   public String removeOuterParentheses(String s) {
        int x = 0, y = 0;
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') x++;
            else x--;

            if( x == 0){
                ss.append(s.substring(y+1, i));
                y = i+1;
            }
        }

        return ss.toString();
    }
}