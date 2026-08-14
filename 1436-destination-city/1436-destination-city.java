class Solution {
    public String destCity(List<List<String>> paths) {

        Map<String, Integer> outdeg = new HashMap<>();
        List<String> x = new ArrayList<>();

        for (List<String> cur: paths) {
           outdeg.put(cur.get(0), outdeg.getOrDefault(cur.get(0), 0) + 1);
           if (!x.contains(cur.get(0))) x.add(cur.get(0));
        }

        for (List<String> cur: paths) {
            if (outdeg.getOrDefault(cur.get(0), 0) == 0) {
                return cur.get(0);
            }
            if (outdeg.getOrDefault(cur.get(1), 0) == 0) {
                return cur.get(1);
            }
        }
        return "";
    }
}