class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse = nse(arr);
        int[] pse = pse(arr);
        long ans = 0;

        for (int i = 0; i < arr.length; i++) {

            int left = i - pse[i];
            int right = nse[i] - i;

            ans = (ans + (long)arr[i] * left * right) % 1000000007;
        }

        return (int)ans;

    }
        public int[] nse(int[] a){

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[a.length];

        for(int i = a.length - 1; i >= 0; i--){

            // >= for duplicates
            while(!st.isEmpty() && a[st.peek()] >= a[i]){
                st.pop();
            }

            if(st.isEmpty())
                ans[i] = a.length;
            else
                ans[i] = st.peek();

            st.push(i);
        }

        return ans;
    }

    // Previous Smaller Element
    public int[] pse(int[] a){

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[a.length];

        for(int i = 0; i < a.length; i++){

            // > for duplicates
            while(!st.isEmpty() && a[st.peek()] > a[i]){
                st.pop();
            }

            if(st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();

            st.push(i);
        }

        return ans;
    }
}