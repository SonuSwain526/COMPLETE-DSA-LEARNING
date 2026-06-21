class Solution {
    public int numberOfSpecialChars(String word) {
        int c = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                c++;
            }
        }

        char[] ar1 = new char[c];
        char[] ar2 = new char[word.length() - c];

        int x = 0, y = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
               ar1[x] = Character.toLowerCase(word.charAt(i));
               x++;
            }else{
                ar2[y] = word.charAt(i);
                y++;
            }
        }
        Arrays.sort(ar1);
        Arrays.sort(ar2);

        x = 0;
        y = 0;
        c = 0;
        while(x < ar1.length && y < ar2.length){
            if(ar1[x] == ar2[y]){
                c++;
                char ch = ar1[x];
                while(x < ar1.length && ar1[x] == ch) x++;
                while(y < ar2.length && ar2[y] == ch) y++;
            }else if(ar1[x] < ar2[y]){
                x++;
            }else   
                y++;
        }
        return c;
    }
}