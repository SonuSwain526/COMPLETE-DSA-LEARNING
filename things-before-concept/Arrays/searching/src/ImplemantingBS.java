public class ImplemantingBS {
    public static void main(String[] args) {
        int[] x = {1,2,3,4,78,100,120,123,300};
        int target = 123;
        int start = 0;
        int end = x.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(x[start] < x[end]){
                if (x[mid] < target){
                    start = mid +1;
                }
                else if(x[mid] > target) {
                    end = mid - 1;
                }
                else if(x[mid] == target) {
                    System.out.println(mid);
                    return;
                }
                else {
                    System.out.println("elem not found");
                    return;
                }
            }
            if(x[0] > x[x.length-1]){
                if (mid < target){
                    end = mid - 1;
                }
                else if(mid > target) {
                    start = mid +1;

                }
                else if(mid == target)
                    System.out.println(mid);
                else
                    System.out.println("elem not found");
            }
        }
    }
}
