class Solution {
public static int[] nextGreaterElement(int[] nums1, int[] nums2) {


        int[] ans = new int[10001];
        // int[] ex = new int[nums2.length];
        Stack<Integer> x = new Stack<Integer>();
        for(int i = nums2.length - 1; i >= 0; i--){
            if(!x.isEmpty() && x.peek() <= nums2[i]){
                while ( !x.isEmpty() && x.peek() <= nums2[i]){
                    x.pop();
                }
            }

            if(x.isEmpty()) {
                ans[nums2[i]] = -1;
                // ex[i] = -1;
            }
            else {
                ans[nums2[i]] = x.peek();
                // ex[i] = x.peek();
            }
            x.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = ans[nums1[i]];
        }
        return nums1;
    }
}