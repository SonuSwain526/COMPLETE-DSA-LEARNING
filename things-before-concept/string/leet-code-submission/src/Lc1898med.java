public class Lc1898med {
    public static void main(String[] args) {
        int[] x = {0, 6, 12, 18, 24};
        System.out.println(maximumRemovals("aaaaaabbbbbbccccccddddddeeeeee", "abcde", x));
    }
    public static int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length;
        int ans = 0;

        while(l <= r){

            int mid = (l + r) / 2;

            if(check(s, p, removable, mid)){
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    static boolean check(String s, String p, int[] removable, int k){

        boolean[] removed = new boolean[s.length()];

        for(int i = 0; i < k; i++){
            removed[removable[i]] = true;
        }

        int i = 0, j = 0;

        while(i < s.length() && j < p.length()){

            if(!removed[i] && s.charAt(i) == p.charAt(j)){
                j++;
            }

            i++;
        }

        return j == p.length();
}}
