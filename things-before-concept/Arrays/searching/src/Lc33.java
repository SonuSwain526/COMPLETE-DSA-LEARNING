public class Lc33 {
    public static void main(String[] args) {
        int[] arr = {2, 5,6,0,0,1,2};
        int target = 0;
        int pivot = findIx(arr);
        System.out.println(pivot);
        System.out.println(bs(arr,target,0, pivot));
        System.out.println(bs(arr,target,pivot+1, arr.length-1));
//        if()
    }
    public static int findIx(int[] x){
        int s = 0, e = x.length-1;
        while (s<=e){
            int mid = (s+e)/2;
            if(x[e] == x[s] || x[mid] > x[mid+1]){
                return mid;
            } else if (x[mid] >= x[s]) {
                s = mid+1;
            }
            else
                e = mid - 1;
        }
        return (s);
    }
    public static int bs(int[] x, int target, int s, int e){
        while (s<=e){
            int mid = (s+e)/2;
            if(x[mid] == target){
                return mid;
            } else if (x[mid] < target) {
                s = mid+1;
            }
            else
                e = mid - 1;
        }
        return -1;
    }
}
