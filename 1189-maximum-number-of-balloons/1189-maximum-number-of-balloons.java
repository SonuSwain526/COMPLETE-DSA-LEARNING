class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] ar = new int[5];

        for ( int i = 0; i < text.length(); i++){
            char c = text.charAt(i);

            if(c == 'a') ar[0]++;
            if(c == 'b') ar[1]++;
            if(c == 'l') ar[2]++;
            if(c == 'o') ar[3]++;
            if(c == 'n') ar[4]++;
        }
        int min = Integer.MAX_VALUE;
        for ( int i = 0; i < 5; i++){
            if(i != 2 && i != 3){
                min = Math.min(min, ar[i]);
            }
        }
        int db = Math.min(ar[2], ar[3]);

        if(min*2 <= db) return min;
        if(min * 2 > db) return db/2;
        // if(min * 2 < db) return min;
        return 0;
    }
}