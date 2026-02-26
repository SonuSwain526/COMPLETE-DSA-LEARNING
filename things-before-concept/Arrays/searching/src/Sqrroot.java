public class Sqrroot {
    public static void main(String[] args) {
        int n = 300000;
        int start = 0;
        int end = n;
        int ans=0;
        while(start<end){
            int mid = (start+end)/2;
            if(n == ((long) mid *mid)){
                System.out.println(mid);
                return;
            }
           else if(((long) mid * mid) < n){
                start = start + 1;
                ans = mid;

            }
            else if(((long) mid * mid) > n){
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
