class Solution {
    public int characterReplacement(String s, int x) {
        int n = s.length();

        boolean[] checker = new boolean[26];
        
        for(int i = 0; i < n; i++){
            checker[s.charAt(i) - 'A'] = true;
        }

        if(x == n) return n;
        // char c = s.charAt(0);
        int maxLe = Integer.MIN_VALUE;

        for(int i = 0; i < 26; i++){
            if(checker[i]){
                int j = 0;
                int c = 'A' + i;
                int size = 0;
                int k = x;
                if ( k == 0){
                    for (int l = 0; l < n; l++){
                        char cur = s.charAt(l);
                        if(cur != c){
                            size = 0;
                        }else size++;
                        // size++;
                        maxLe = Math.max(maxLe, size);
                    }
                }
                else {for (int l = 0; l < n; l++ ){
                    char cur = s.charAt(l);
                    if( k == 0 && cur != c){
                        while (j < n){
                            if(s.charAt(j) != c){
                                // c = s.charAt(j);
                                j++;
                                size--;
                                k++;
                                break;
                            }
                            j++;
                            size--;
                        }
                    }
                    if (cur != c){
                        k--;
                    }
                    size++;
                    maxLe = Math.max(maxLe, size);
                }
                }
            }
        }
       return maxLe;
    }
}