public class Lc3629med {
    public static void main(String[] args) {
        int[] ar = {4,6,5,8};
        System.out.println(x(ar, 0, 0));
    }
    public static int x(int[] ar, int ix, int step){
        if(ix == ar.length-1){
            return step;
        }
        if (ix < 0 || ix >= ar.length) {
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        if(isPrime(ar[ix])){
            if(ar[ar.length-1] % ar[ix] == 0) return step+1;
            for (int i = ix+1; i < ar.length-2; i = i+2) {
//                step = x(ar, i, step+1);
                ans = Math.min(ans,
                        x(ar, i, step + 1));

                // optional adjacent jump
                if (i + 1 < ar.length) {
                    ans = Math.min(ans,
                            x(ar, i + 1, step + 1));
                }
            }
        }else {
            ans = Math.min(ans,
                        x(ar, ix+1, step+1));
            if(ix > 0){
                ans = Math.min(ans, x(ar, ix-1, step+1));
            }
        }

        return ans;
    }
    public static boolean isPrime(int n){

        if(n < 2) return false;

        if(n == 2) return true;

        if(n % 2 == 0) return false;

        for(int i = 3; i * i <= n; i += 2){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}
