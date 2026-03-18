public class Main {
    public static void main(String[] args) {
//        boolean[] x;
        int[] x= {1,2,3,4,5};
        System.out.println(x(9, 0,4 , x));
    }
    public static int x(int n,int l, int r, int[] ar){
        int mid = l + (r-l)/2;
        if(ar[mid] == n){
            return mid;
        } else if (ar[mid] > n) {
            return x(n, l, mid-1, ar);
        }else return x(n, mid+1, r, ar);
//        return 0;
    }
}