public class Lc2078esey {
    public static void main(String[] args) {

    }
    public int maxDistance(int[] colors) {
        int s = 0, e = 0;
        int maxdi = 0;
//        for (int i = 0; i < colors.length; i++) {
//            if(colors[i] != colors[i+1]){
//                maxdi = Math.max(maxdi, i - s);
//                s = i+1;
//            }
//        }

        int i = 0, j = colors.length-1;
        while (i < colors.length && j >= 0){
            if(colors[i] != colors[j]) return (j-i);
            else j--;
        }
        return 0;
    }
}
