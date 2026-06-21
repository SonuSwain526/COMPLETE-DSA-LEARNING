class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1) return false;
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if(c == ')' || c == '}' || c == ']'){
                if((s2.isEmpty() || s2.peek() != c)){
                    return false;
                }else {
                    s1.pop();
                    s2.pop();
                }
            }

            if(c == '(' || c == '{' || c == '['){
                s1.push(c);
                if( c == '(') s2.push(')');
                if( c == '{') s2.push('}');
                if( c == '[') s2.push(']');
            }
            i++;
        }

        return s1.isEmpty();
    }
}