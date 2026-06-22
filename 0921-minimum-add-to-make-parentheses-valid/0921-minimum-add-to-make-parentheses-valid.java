class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> c = new Stack<>();
        int a=0, b=0;
        for(int i = 0; i < s.length(); i++){
            char cc = s.charAt(i);
            if(cc == '(') {
                c.push(cc);
            }
            else {
                if(c.isEmpty()) a++;
                else c.pop();
            }
        }
        return (c.size() + a);
    }
}