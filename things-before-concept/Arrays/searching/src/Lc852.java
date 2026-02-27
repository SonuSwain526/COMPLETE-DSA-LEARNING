public class Lc852 {
    public static void main(String[] args) {
        int[] x = {3,2,1};
        System.out.println(mountainsLargeElem(x));
    }
    public static int mountainsLargeElem(int[] arr){
        int s = 0, e = arr.length-1;
        while (s <= e){
            int mid = (s+e) / 2;
            if((mid != arr.length-1 && mid != 0)) {
                if (LargeElem(arr[mid-1], arr[mid], arr[mid+1]) == arr[mid]) {
                    return arr[mid];
                } else if (LargeElem(arr[mid-1], arr[mid], arr[mid+1]) == arr[mid+1]) {
                    s = mid+1;
                }
                else
                    e = mid - 1;
            } else if (mid == 0) {
                if(arr[mid+1] > arr[mid]){
                    return 1;
                }else
                    return mid;
            } else if (mid == arr.length-1){
                if(arr[mid-1] > arr[mid]){
                    return (mid-1);
                }else
                    return mid;
            }

        }
        return arr[s];
    }
    public static int LargeElem(int a, int b, int c){
        if(a < b && b > c){
            return b;
        } else if (b < a && a > c) {
            return a;
        }
        else
            return c;
    }
}
