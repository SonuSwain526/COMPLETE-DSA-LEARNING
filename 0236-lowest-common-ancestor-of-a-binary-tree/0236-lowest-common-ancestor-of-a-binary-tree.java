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
    List<TreeNode> x;
    List<TreeNode> y;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        x = new ArrayList<>();
        y = new ArrayList<>();

        helper(root, new ArrayList<>(), p.val, true);
        helper(root, new ArrayList<>(), q.val, false);
        System.out.print(x);
        System.out.print(y);

        // int i = 0, j = 0;
        TreeNode last = null;

        int i = 0;
        while (i < x.size() && i < y.size()) {
            if (x.get(i) != y.get(i)) {
                return last;
            }
            last = x.get(i);
            i++;
        }

        return last;
    }
        public void helper(TreeNode cur, List<TreeNode> l, int t, boolean b) {
        if (cur == null) return;

        l.add(cur);

        if (cur.val == t) {
            if (b)
                x = new ArrayList<>(l);
            else
                y = new ArrayList<>(l);
            l.remove(l.size() - 1);
            return;
        }

        helper(cur.left, l, t, b);
        helper(cur.right, l, t, b);

        l.remove(l.size() - 1);
    }
    // public void helper(TreeNode cur, List<TreeNode> l, int t, boolean b){
    //     if (cur == null) return;
    //     if(cur.left == null && cur.right == null) {
    //         l.add(cur);
    //         if (cur.val == t) {
    //             // l.add(cur);
    //             if(b) x = new ArrayList(l);
    //             else y = new ArrayList(l);
    //             return;
    //         }
    //         return;
    //     }

    //     if (cur.val == t) {
    //         l.add(cur);
    //         if(b) x = new ArrayList(l);
    //         else y = new ArrayList(l);
    //         return;
    //     }

    //     l.add(cur);
    //     helper(cur.left, l, t,b);
    //     helper(cur.right, l, t,b);
    //     l.removeLast();

    //     // return;

    // }
}