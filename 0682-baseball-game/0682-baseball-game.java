class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        List<Integer> x = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String cur = operations[i];
            if (cur.equals("D")) x.add(x.get(x.size() - 1) * 2);
            else if (cur.equals("C")) x.removeLast();
            else if (cur.equals("+")) x.add(x.get(x.size() - 1) + x.get(x.size() - 2));
            else x.add(Integer.parseInt(cur));
        }
        for (int a: x) sum += a;

        return sum;
    }
}