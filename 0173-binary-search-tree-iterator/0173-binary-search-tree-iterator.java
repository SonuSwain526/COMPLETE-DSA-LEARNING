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

    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        put(root);
    }

    void put(TreeNode cur){
        if(cur == null) return;
        s.push(cur);
        put(cur.left);
    }
    
    public int next() {
        TreeNode x =s.pop();;
        if(x.right != null) put(x.right);
        // s.pop();
        return x.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}


// class BSTIterator {

//     List<Integer> x;
//     int i;

//     public BSTIterator(TreeNode root) {
//         x = new ArrayList<>();
//         i = 0;
//         iot(root);
//     }
//     public void iot(TreeNode cur){
//         if (cur == null) return;

//         iot(cur.left);
//         x.add(cur.val);
//         iot(cur.right);
//     }
    
//     public int next() {
//         return x.get(i++);
//     }
    
//     public boolean hasNext() {
//         return (i < x.size());
//     }
// }
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */