class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, s.length(), ans, new ArrayList<>());
        return ans;
    }
    void helper(String s, int start,int end, List<List<String>> ans, List<String> list) {
        
        if (start >= end) ans.add(new ArrayList<>(list));
        for (int i = start; i < end; i++) {
            String cur = s.substring(start, i+1);
            if (!checker(new StringBuilder(cur))) continue;
            list.add(cur);
            helper(s, i + 1, end, ans, list);
            list.removeLast();
        }
    }
    boolean checker(StringBuilder sb) {
        StringBuilder x = new StringBuilder(sb);
        return x.toString().equals(x.reverse().toString());
    }
}


























