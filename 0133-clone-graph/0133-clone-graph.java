/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node[] vis;
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        // vis = new Node[101];
        map = new HashMap<>();
        // Arrays.fill(vis, null);
        dfs(node);
        return map.get(node);
    }

    Node dfs(Node cur) {
        if (map.containsKey(cur)) return map.get(cur);
        map.put(cur, new Node(cur.val));

        for (Node n: cur.neighbors) {
            map.get(cur).neighbors.add(dfs(n));
        }
        return map.get(cur);
    }

    // Node dfs(Node cur) {
    //     if (vis[cur.val] != null) return vis[cur.val];
    //     vis[cur.val] = new Node(cur.val);

    //     for (Node n: cur.neighbors) {
    //         vis[cur.val].neighbors.add(dfs(n));
    //     }
        
    //     return vis[cur.val];
    // }
}