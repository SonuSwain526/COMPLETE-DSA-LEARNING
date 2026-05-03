public class Lc1855med {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));

    }
    public static int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int g = -1000;
        boolean x = false;
        while (i < nums1.length && j < nums1.length){
            if(nums1[i] <= nums2[j]){
                g = Math.max(g, Math.abs(i - j));
                x = true;
                j++;
            }else {
                i++;
            }
        }
//        for (int j = 0; j < nums2.length; j++) {
//            int i = bs(nums2, nums1[j], j);
//            if( j < i){
//                g = Math.max(g, Math.abs(i - j));
//            }
//        }
        if(x) return g;
        else return 0;
    }
    public static int bs(int[] a, int v, int s){
        int e = a.length;

        while (s < e){
            int mid = s + (e - s)/2;

            if(a[mid] >=  v){
                s = mid;
            }else e = mid - 1;
        }
        return s;
    }
}
