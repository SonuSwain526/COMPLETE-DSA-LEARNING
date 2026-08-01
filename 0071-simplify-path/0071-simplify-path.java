class Solution {
    public String simplifyPath(String path) {
        List<String> arr = new ArrayList<>();

        int n = path.length();

        int j = 0;

        for(int i = 0; i < n; i++){
            if (path.charAt(i) == '/'){
                if (j != i) arr.add(path.substring(j, i));
                j = i+1;
            }
        }

        if (path.charAt(n-1) != '/'){
            for (int i = n-1; i >= 0; i--){
                if (path.charAt(i) == '/'){
                    arr.add(path.substring(i+1)); break;
                }
            }
        }

        Stack<String> s = new Stack<>();

        for (int i = 0; i < arr.size(); i++){
            if(!arr.get(i).equals(".")) s.push(arr.get(i));

            if (!s.isEmpty() && s.peek().equals("..")){
                if (!s.isEmpty()) s.pop();
                if (!s.isEmpty()) s.pop();
            }
        }

        if (s.isEmpty()) return "/";

        // StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();

        while (!s.isEmpty()){
            ans.add("/" + s.peek());
            s.pop();
        }
        Collections.reverse(ans);
        return String.join("", ans);
    }
}