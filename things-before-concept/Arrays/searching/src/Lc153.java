public class Lc153 {
    public static void main(String[] args) {
        int[] x = {11,13,15,17};
        System.out.println(x.length);
        System.out.println(findPivot(x));
    }
 public static int findPivot(int[] x){
        int s = 0, e = x.length-1;
        while(s <= e){
            int mid = (s+e)/2;
            if(x[s] == x[e] || x[mid] > x[mid+1]){
                return mid;
            }else if(x[mid] >= x[s]){
                s = mid+1;
            }else
                e = mid - 1;
        }
        return s;
    }}
