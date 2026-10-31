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
    HashMap<Node, Node> check = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (check.getOrDefault(node, null) != null) return check.get(node);

        Node x = new Node(node.val);

        check.put(node, x);

        List<Node> cur = new ArrayList<>();

        for (Node xx: node.neighbors)
                cur.add(cloneGraph(xx));

        x.neighbors = cur;
        return x;
    }
}