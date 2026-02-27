public class Lc367 {
    public static void main(String[] args) {
        int num = 25;
        System.out.println(isPerfectSquare(num));
    }
    static public boolean isPerfectSquare(int num) {
        int start = 0, end = num - 1;
        while(start <= end){
            int mid = (start + end)/ 2;
            if(((long) mid * mid) < num){
                start = mid+1;
            }
            else if(((long) mid *mid) > num){
                end = mid -1;
            }
            else
                return true;
        }
        return false;
    }
}
