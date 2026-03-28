import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] a, int s, int e){
        if(e <= s) return;
        int m = s+(e-s)/2;

        sort(a, s, m);
        sort(a, m+1, e);
        merge(s, e, m, a);
        System.out.println(Arrays.toString(a));
    }
    public static void merge(int start, int end, int mid, int[] x){
        int[] ans = new int[end-start + 1];
        int s = start;
        int m = mid+1;
        int e = end;
        int i = 0;
        while (s <= mid && m <= end){
            if(x[s] <= x[m]){
                ans[i] = x[s];
                s++;
            }else {
                ans[i] = x[m];
                m++;
            }
            i++;
        }
        while (s <= mid){
            ans[i++] = x[s++];
        }
        while (m <= end){
            ans[i++] = x[m++];
        }
        for (int j = 0; j < ans.length; j++) {
            x[start+j] = ans[j];
        }

    }
}
