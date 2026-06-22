class Solution {
     public static String decodeString(String s) {
        Stack<Integer> a = new Stack<>();
        Stack<Character> b = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                a.push(num);
                i--; // compensate for the for-loop increment
            }
            else if (c == '[') {
                b.push(c);
            }
            else if (Character.isLetter(c)) {
                b.push(c);
            }
            else if (c == ']') {

                StringBuilder curr = new StringBuilder();

                while (!b.isEmpty() && b.peek() != '[') {
                    curr.append(b.pop());
                }

                curr.reverse();

                b.pop(); // remove '['

                int repeat = a.pop();

                String str = curr.toString();
                StringBuilder expanded = new StringBuilder();

                for (int j = 0; j < repeat; j++) {
                    expanded.append(str);
                }

                for (char ch : expanded.toString().toCharArray()) {
                    b.push(ch);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!b.isEmpty()) {
            ans.append(b.pop());
        }

        return ans.reverse().toString();
    }
}