class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] s = preorder.split(",");

        int lev = 0, nonlev = 0;

        int i = 0;
        for (i = 0; i < s.length && nonlev + 1 != lev; i++){
            if (s[i].equals("#")) lev++;
            else nonlev++;
        }
        return nonlev + 1 == lev && i == s.length;
    }
}