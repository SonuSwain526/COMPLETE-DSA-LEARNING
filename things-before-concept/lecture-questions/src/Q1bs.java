public class Q1bs {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(x(arr, 8));
    }
    public static int x(int[] a, int target){
        int s = 0, e = a.length-1;
        while(s <= e){
            int mid = (s+e) / 2;
            if(a[mid] == target){
                return mid;
            } else if (a[mid] < target) {
                s = mid+1;
            }else
                e = mid-1;
        }
        return s-1;
    }
}
