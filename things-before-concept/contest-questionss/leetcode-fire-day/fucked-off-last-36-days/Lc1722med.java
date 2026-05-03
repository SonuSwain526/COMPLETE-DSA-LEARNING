public class Lc1722med {
    public static void main(String[] args) {
        int[] s = {1,2,3,4};
        int[] t = {2,1,4,5};
        int[][] a = {{0,1}, {2,3}};
        System.out.println(minimumHammingDistance(s, t, a));
    }
    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        for (int i = 0; i < allowedSwaps.length; i++) {
            if(source[allowedSwaps[i][0]] != target[allowedSwaps[i][0]] && source[allowedSwaps[i][1]] != target[allowedSwaps[i][1]] ){
                if(source[allowedSwaps[i][0]] == target[allowedSwaps[i][1]] || source[allowedSwaps[i][1]] == target[allowedSwaps[i][0]] ){
                    int temp = source[allowedSwaps[i][0]];
                    source[allowedSwaps[i][0]] = source[allowedSwaps[i][1]];
                    source[allowedSwaps[i][1]] = temp;
                }
            }
        }

        int c = 0;
        for (int i = 0; i < source.length; i++) {
            if(source[i] != target[i]){
                c++;
            }
        }
        return c;
    }
}
