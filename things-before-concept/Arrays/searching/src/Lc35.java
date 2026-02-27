public class Lc35 {
    public static void main(String[] args) {
        System.out.println(x(new int[]{1,2,3,4,5,6}, 7));
    }
    public static int x(int[] y, int target){
        int s = 0, e = y.length - 1;
        while (s<=e){
            int mid = (s+e)/2;
            if(y[mid] < target){
                s = mid+1;
            } else if (y[mid] > target) {
                e = mid - 1;
            }
            else
                return mid;
        }
        return s;
    }
}
