class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] vis = new boolean[rooms.size()];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        int c = 1;

        while ( !q.isEmpty() ) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int keys: rooms.get(cur)) {
                    if (!vis[keys]) {
                        vis[keys] = true;
                        c++;
                        q.add (keys);
                    }
                }
            }
        }

        return c == rooms.size();
        
    }
}