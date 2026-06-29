class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n = word.length();
        int count = 0;
        for ( int k = 0; k < patterns.length; k++){
            String curW = patterns[k];
            if (word.contains(curW)) {
                count++;
            }
            // int i = 0, j = 0;
            // while ( i < n && j < curW.length()){
            //     if(j == curW.length() - 1 && (curW.charAt(j) == word.charAt(i))) {
            //         count++;
            //         break;
            //     }
            //     if(curW.charAt(j) != word.charAt(i)){
            //         j = 0;
            //         i++;
            //     }else {
            //         i++;
            //         j++;
            //     }
            // }
        }

        return count;
    }
}