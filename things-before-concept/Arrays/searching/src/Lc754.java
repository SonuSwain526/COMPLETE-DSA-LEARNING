public class Lc754 {
    public static void main(String[] args) {
        System.out.println(reachNumber(5));
        System.out.println(reachNumbeneg(5));
    }
    public static int reachNumber(int target) {
        int s = 0, e = target;
        int count = 0;
//        int ans
        while(s+count != target){
            int mid = (s+e)/2;
            count++;
            if(s + count == target){
                return count;
            }else if(count + mid < target)

                s = s + count;
            else
                s = s - count;
        }
        return count;
    }
    public static int reachNumbeneg(int target) {
        int s = -1, e = target;
        int count = 1;
//        int ans
        while(s + count != target){
            count++;
            if(s + count == target){
                return count;
            }else if(count + s < target)
                s = s + count;
            else
                s = s - count;
        }
        return count;
    }
}
