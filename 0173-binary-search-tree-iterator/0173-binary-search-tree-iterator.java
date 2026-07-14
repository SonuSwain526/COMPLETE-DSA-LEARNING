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
class BSTIterator {

    List<Integer> x;
    int i;

    public BSTIterator(TreeNode root) {
        x = new ArrayList<>();
        i = 0;
        iot(root);
    }
    public void iot(TreeNode cur){
        if (cur == null) return;

        iot(cur.left);
        x.add(cur.val);
        iot(cur.right);
    }
    
    public int next() {
        return x.get(i++);
    }
    
    public boolean hasNext() {
        return (i < x.size());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */