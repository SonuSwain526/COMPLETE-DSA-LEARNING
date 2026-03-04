public class Lc1011med {
    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(x, 5));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int s = 0, e = 0;
        for(int x: weights){
            s = Math.max(s, x);
            e += x;
        }
        int ans = -1;
        while (s<e){
            int mid = s + (e-s)/2;
            int cs = 0;
            int count = 1;
            for(int x: weights){
                if(x+cs > mid ){
                    cs = x;
                    count++;
                }else cs += x;
            }
            if(count == days){
                ans = mid;
                e = mid;
            }
            else if(count < days){
                e = mid;
            }else s = mid+1;
        }
    return ans;
    }
}
