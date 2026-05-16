public class dt_may_15 {
    public static void main(String[] args) {
        int[] a = {4,5,6,1,2,3,10,12,15};
        System.out.println(findMin(a));
        int[] x = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        System.out.println(bs(x));
    }
    public static int findMin(int[] nums) {
        int lm = bs1(nums);
        int rm = bs2(nums);

        return Math.min(lm, rm);
    }

    public static int bs1(int[] a){
        int l = 0, r = a.length-1;
        int cur = 0;

        if(l < r){
            int mid = l + (r - l)/2;

            if(mid > 0 && mid < a.length-1 && !(a[mid-1] < a[mid] && a[mid] < a[mid+1])){
                return Math.min(Math.min(a[mid-1], a[mid]), a[mid+1]);
            }
            else{
                r = mid-1;
//                cur =
            }
        }

        return a[r];
    }

    public static int bs2(int[] a){
        int l = 0, r = a.length-1;
        int cur = 0;

        if(l < r){
            int mid = l + (r - l)/2;

            if(mid > 0 && mid < a.length-1 && !(a[mid-1] < a[mid] && a[mid] < a[mid+1])){
                return Math.min(Math.min(a[mid-1], a[mid]), a[mid+1]);
            }
            else{
                l = mid+1;
//                cur =
            }
        }

        return a[r];
    }

    public static int bs(int[] a){
        int l = 0, r = a.length-1;
        int cur = 0;

        if(l < r){
            int mid = l + (r - l)/2;

            if(mid > 0 && mid < a.length-1 && !(a[mid-1] < a[mid] && a[mid] < a[mid+1])){
                return Math.min(Math.min(a[mid-1], a[mid]), a[mid+1]);
            }

            if(a[mid-1] < a[mid] && a[mid] < a[mid+1]){
                r = mid-1;
            }else {
                l = mid+1;
            }

        }

        return a[r];
    }

}
