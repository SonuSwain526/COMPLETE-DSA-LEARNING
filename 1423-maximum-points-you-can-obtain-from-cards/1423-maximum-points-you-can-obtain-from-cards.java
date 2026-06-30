class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] mergeArr = new int[2 * k];
        
        for (int i = 0; i < k; i++){
            mergeArr[i] = cardPoints[n - k + i];
            mergeArr[i + k] = cardPoints[i];
        }

        int max = Integer.MIN_VALUE;

        int l = 0;
        int c = 0;
        int curS = 0;

        for (int i = 0; i < k * 2; i++){
            curS += mergeArr[i];
            c++;
            if(c > k){
                curS -= mergeArr[l];
                l++;
                c--;
            }

            max = Math.max(max, curS);
        }
        return max;
    }
}