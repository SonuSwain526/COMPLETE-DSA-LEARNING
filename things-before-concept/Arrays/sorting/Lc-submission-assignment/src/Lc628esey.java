public class Lc628esey {
    public static void main(String[] args) {

        int[] nums = {-5,-4,1,5};

        int x =Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;;

        for(int n: nums){
            if(x > n || y > n || c > n){
                if(x > n){ x = n;};
            }
            else if(x > n || y > n || c > n){
                if(y > n){ y = n;};
            }
            else if(x > n || y > n || c > n){
                if(c > n){ c = n;};
            }
        }

    }
}
