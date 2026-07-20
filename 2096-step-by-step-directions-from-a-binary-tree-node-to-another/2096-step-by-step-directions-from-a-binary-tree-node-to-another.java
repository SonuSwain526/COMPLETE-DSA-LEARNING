/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> x = new HashMap<>();
    Set<TreeNode> y = new HashSet<>();
    public String getDirections(TreeNode root, int startValue, int destValue) {

        setRoot(root, null);
        TreeNode stNode = find(root, startValue);

        return path(stNode, destValue, new StringBuilder());
    }
    String path(TreeNode cur, int t, StringBuilder sb) {
        if (cur == null) return null;

        if (cur.val == t) return sb.toString();

        if (!y.contains(cur)) {
            y.add(cur);

            sb.append('L');
            String ans = path(cur.left, t, sb);
            sb.deleteCharAt(sb.length() - 1);
            if (ans != null) return ans;

            sb.append('R');
            ans = path(cur.right, t, sb);
            sb.deleteCharAt(sb.length() - 1);
            if (ans != null) return ans;

            sb.append('U');
            ans = path(x.get(cur), t, sb);
            sb.deleteCharAt(sb.length() - 1);
            if (ans != null) return ans;

            y.remove(cur);
        }

        return null;
    }

    void setRoot(TreeNode cur, TreeNode root){
        if (cur == null) return;

        x.put(cur, root);
        setRoot(cur.left, cur);
        setRoot(cur.right, cur);
    }

    TreeNode find(TreeNode cur, int t){
        if (cur == null) return null;

        if (cur.val == t) return cur;

        TreeNode a = find(cur.left, t);
        if (a != null) return a;

        return find(cur.right, t);
    }
}