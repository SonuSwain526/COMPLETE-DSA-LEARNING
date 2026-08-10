class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> set = new HashSet<>();

        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }
        if (set.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        q.add("0000");
        set.add("0000");
        int level  = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) return level;
                for (int j = 0; j < 4; j++) {
                    int next = (Integer.parseInt(cur.substring(j, j+1)) + 1) % 10;
                    String s = cur.substring(0, j) + next + cur.substring(j+1);
                    if (!set.contains(s)) {
                        set.add(s);
                        q.add(s);
                    }
                    next = (Integer.parseInt(cur.substring(j, j+1)) - 1);
                    if (next < 0) next = 9;
                    s = cur.substring(0, j) + next + cur.substring(j+1);
                    if (!set.contains(s)) {
                        set.add(s);
                        q.add(s);
                    }
                }
            }
            level++;
        }

        return -1;

    }
}