public class ArrPr1 {
    public static void main(String[] args) {
        int[] arr = {-1, -4,-23, -3, -14};
        int[] reducedArr = new int[arr.length];
        int maxelem = largeElem(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != maxelem){
                reducedArr[i] = arr[i];
            }
            else
                reducedArr[i] = 0;
        }
        System.out.println(largeElem(reducedArr));
    }

    static int largeElem(int[] arr) {
     int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
