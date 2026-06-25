class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> dataStru = new Stack<>();
        dataStru.push(-1);
        int n = s.length();
        int cur = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            // if(dataStru.isEmpty() && c == ')') {
            //     max = Math.max(max, cur);
            //     cur = 0;
            //     continue;
            // }
            if(c == '(') dataStru.push(i);

            else{
                dataStru.pop();
                if(dataStru.isEmpty()) dataStru.push(i);
                else{
                    max = Math.max(max, i - dataStru.peek());
                }
                // cur += 2;
            }
        }


        return Math.max(cur, max);
    }
}