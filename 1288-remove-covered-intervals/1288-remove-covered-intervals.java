class Solution {
    public int removeCoveredIntervals(int[][] it) {
        int n = it.length;
        Arrays.sort(it, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // Descending second element
            }
            return Integer.compare(a[0], b[0]);     // Ascending first element
        });
        int c = 0;
        for (int i = n-1; i >= 0; i-- ){
            for(int j = i-1; j >= 0; j--){
                if (it[i][0] >= it[j][0] && it[i][1] <= it[j][1]){
                    c++;
                    break;
                }
            }
        }

        return n - c;
    }
}