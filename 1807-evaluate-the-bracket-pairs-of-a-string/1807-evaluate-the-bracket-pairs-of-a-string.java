class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> ss: knowledge) {
            map.put(ss.get(0), ss.get(1));
        }
        StringBuilder sb = new StringBuilder();
        String ans = "" + s;
        for (int i = 0; i < s.length(); i++) {
            String add = "" + s.charAt(i);
            if (s.charAt(i) == '(') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == ')') {
                        String x = s.substring(i+1, j);
                        add = "?";
                        if (!map.getOrDefault(x, "").equals("")){
                            add = map.get(x);
                        }
                        i = j;
                        break;
                    }
                }
            }
            sb.append(add);
        }
        return sb.toString();
    }
}