class Solution {
    public String removeKdigits(String nums, int k) {
        if(k == nums.length()) return "0";

        Stack<Character> s = new Stack<>();
        if(nums.charAt(0) == '0'){
            int i = 0;
            while(i < nums.length() && nums.charAt(i) == '0'){
                i++;
            }
            nums = nums.substring(i);
        }
        if(k >= nums.length()) return "0";

        for(int i = 0; i < nums.length(); i++){
            char cur = nums.charAt(i);
            while(!s.isEmpty() && s.peek() > cur && k!=0){
                s.pop();
                --k;
                if(k == 0) break;
            }
            // if(k == 0) break;
            s.push(cur);
        }
        int size = s.size();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append(s.peek());
            s.pop();
        }
        sb.reverse();
        if(k != 0){
           sb.delete(sb.length() - k, sb.length());
        }
        nums = sb.toString();
        if(nums.charAt(0) == '0' && nums.length() != 1){
            int i = 0;
            while(i < nums.length() && nums.charAt(i) == '0'){
                i++;
            }
            nums = nums.substring(i);
        }
        if(nums.length() == 0) return "0";
        return nums;
    }
}