class Solution {
    public boolean checkValidString(String s) {

        int max = 0; int min = 0;

        for (char c: s.toCharArray()){
            if (c == '(') {
                max++;
                min++;
            }else if ( c == ')'){
                max--;
                min--;
            }else {
                max++;
                min--;
            }
            min = Math.max(min, 0);

            if (max < 0) return false;
        }
        return min == 0;
    }

    boolean helper( String s, int i, int isVal){

        if (i == s.length()){
            return (isVal == 0);
        }
        if (isVal < 0) return false;

        boolean b = false;

        for (int j = i; j < s.length(); j++){
            char cur = s.charAt(j);

            if (cur == '(') isVal++;
            if (cur == ')') isVal--;
            if (isVal < 0) return false;
            if (cur == '*'){
                b = helper( s, j+1, isVal+1);
                if (b) return true;

                b = helper(s, j+1, isVal-1);
                if (b) return true;

                b = helper(s, j+1, isVal);
                if (b) return true;
            }

        }

        return (b || (isVal == 0));
    }
}