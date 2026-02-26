public class Lc540 {
    public static void main(String[] args) {
        int[] a = {1,1,2,3,3,4,4,8,8};
        System.out.println(xy(a,0,a.length-1,true));
//        System.out.println(xy(a,a.length+1, a.length-1,false));
    }
    public static int xy(int[] arr,int x, int y, boolean isLeft){
        int start = x, end = y;

        int elem=-1;
        while (start<end){
            int mid = (start+end)/2;
//            if(mid == 0||mid == arr.length){
//            if(mid == 0 && arr[mid] != arr[mid+1]){
//                return elem;
//            }
//           else if(mid == arr.length && arr[mid-1] != arr[mid-2]){
//                return elem;
//            }
//           else
//               return elem;
//           }
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid+1]){
                elem = arr[mid];
                return elem;
            } else if (mid % 2 == 1) {
                mid--;
            } else if(arr[mid] == arr[mid+1]){
                start = mid + 2;
            }
            else {
                end = mid;
            }
        }
        return arr[start];
    }
}
