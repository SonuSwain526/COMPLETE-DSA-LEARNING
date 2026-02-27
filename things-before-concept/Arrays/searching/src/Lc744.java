public class Lc744 {
    public static void main(String[] args) {
//        char[] letters = {'b', 'd', 'e', 'g', 'h', 'i', 'j'};
        char[] letters = {'c','f','j'};
        char target = 'z';
        System.out.println(xy(letters, target));
    }
    static char xy(char[] x, char target){
        int start = 0, end = x.length-1;
        System.out.println((int)'d');
        while (start<=end){
            int mid = (start+end)/2;
            if((int)target > (int)x[mid]){
                start = mid+1;
            } else if ((int)target < (int)x[mid]) {
                end = mid - 1;
            }
            else{
                if(mid == x.length-1){
                    return x[0];
                }
                else
                    start = mid+1;
        }}
        return x[start];
    }
}
