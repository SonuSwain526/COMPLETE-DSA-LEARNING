import java.util.Arrays;

public class Lc88esey {
    public static void main(String[] args) {
        int[] x = {1,2,3,0,0,0};
        int[] y = {2,3,4};
//        merge(x, 3, y, 3);
    }
//
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int n1 = nums1.length-1;
    //     int n2 = nums2.length;

    //     for(int k = 0; k < n2; k++){
    //         nums1[n1 - n2 + k] = nums2[k];
    //     }
    //     System.out.println(Arrays.toString(nums1));
    //     for(int i = 0; i < n1 - 1; i++){
    //         boolean sort = false;
    //         for(int j = 0; j < n1 - i - 1; j++){
    //             if(nums1[j] > nums1[j+1]){
    //                 swap(nums1, j+1);
    //                 sort = true;
    //             }
    //         }
    //         if(!sort){
    //                 break;
    //             }
    //     }


    // }
    // public void swap(int[] x, int j){
    //     int temp = x[j];
    //     x[j] = x[j-1];
    //     x[j-1] = temp;
    // }


    int x = m-1;
    int y = n-1;
    while(y >= 0){
        if(x >= 0 && nums1[x] > nums2[y]){
            nums1[n1--] = nums1[x--];

        }else
            nums1[n1--] = nums2[y--];
    }
}
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//
//        for(int k = 0; k < n2; k++){
//            nums1[n1 - n2 + k] = nums2[k];
//        }
//        System.out.println(Arrays.toString(nums1));
//
////        for(int i = 0; i < n1 - 1; i++){
////            for(int j = i+1; j < n1; j++){
////                if(nums1[j] < nums1[j-1]){
////                    swap(nums1, j);
////                }
////            }
////        }
//
//
//    }
//    public static void swap(int[] x, int j){
//        int temp = x[j];
//        x[j] = x[j-1];
//        x[j-1] = temp;
//    }
}
