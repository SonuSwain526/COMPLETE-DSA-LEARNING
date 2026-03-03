public class Lc875Med {
    public static void main(String[] args) {
        int[] x = {30,11,23,4,20};
        int[] y = {3,6,7,11};
        System.out.println(minEatingSpeed(y, 8));
    }
    public static int minEatingSpeed(int[] p, int h) {
        int s = 1, e = 0;
        for(int x: p){
            e = Math.max(e, x);
//            e += x;
        }
        System.out.println(s);
        System.out.println(e);
        while(s <= e){
            int mid = (s + e)/2;
            int epochs = 0;
            for(int x: p){
                if( x <= mid){
                    epochs++;
                }else{
                    epochs += (int) Math.ceil((double) x / mid);
                }
            }
            System.out.println(epochs);
            if(epochs <= h){
                e = mid-1;
            }else
                s = mid+1;
        }
        return s;
    }
}
