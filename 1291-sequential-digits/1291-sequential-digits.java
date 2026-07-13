class Solution {
   public List<Integer> sequentialDigits(int low, int high) {
    String s = "123456789";
    List<Integer> ans = new ArrayList<>();

    for (int len = String.valueOf(low).length();
         len <= String.valueOf(high).length();
         len++) {

        int l = 0;
        int r = len;

        while (r <= 9) {
            int num = Integer.parseInt(s.substring(l, r));

            if (num >= low && num <= high)
                ans.add(num);

            l++;
            r++;
        }
    }

    return ans;
}
}