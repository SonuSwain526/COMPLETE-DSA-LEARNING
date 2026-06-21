class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> ss = new Stack<>();

        for( int i = 0; i < s.length(); i++ ){
            if(ss.isEmpty()){
                ss.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ss.peek()){
                ss.pop();
            }else ss.push(s.charAt(i));
        }
        StringBuilder st = new StringBuilder();
        while(!ss.isEmpty()){
            st.append(ss.peek().toString());
            ss.pop();
        }

        return st.reverse().toString();
    }
}