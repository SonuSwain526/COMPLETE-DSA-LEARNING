class Solution {
    public boolean checkString(String s) {
        boolean x = true;
        // boolean ans = 0;
        for (char c: s.toCharArray()){
            if(!x && c == 'a') return false;
            if (c == 'b') x = false;
        }
        return true;
    }
}