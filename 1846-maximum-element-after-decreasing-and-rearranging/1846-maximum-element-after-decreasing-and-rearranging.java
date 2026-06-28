class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        arr[0] = 1;

        // if(arr[n-1] >= n) return n;

        for(int i = 0; i < n-1; i++){
            int cur = i;
            int next = i+1;
            if(Math.abs(arr[cur] - Math.abs(arr[next])) > 1){
                arr[next] = arr[cur] + 1;
            }
        }

        return arr[n-1];
    }
}