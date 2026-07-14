/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    Map<TreeNode, TreeNode> map;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map = new HashMap<>();

        bfs(root, null);

        if (find(p, q)) return p;

        if (find(q,p)) return q;

        TreeNode cur = p;
        boolean ans = false;
        while (cur != null){
            ans = find(map.get(cur), q);
            if (ans) return map.get(cur);
            cur = map.get(cur);
        }

        return null;

    }

    public void bfs(TreeNode cur, TreeNode root){
        if(cur == null) return;

        map.put(cur, root);

        bfs(cur.left, cur);
        bfs(cur.right, cur);
        
    }

    public boolean find(TreeNode cur, TreeNode tar){
        if(cur == null) return false;

        if (cur.val == tar.val) return true;
        boolean ans = false;
        if (cur.val > tar.val){
           ans = find(cur.left, tar);
        }
        if (cur.val < tar.val){
           ans = find(cur.right, tar);
        }

        return ans;
    }
}