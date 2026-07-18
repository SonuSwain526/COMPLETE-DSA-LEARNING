/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;

        if (root.val == head.val && helper(root, head.next)) return true;

        return isSubPath(head, root.left) || isSubPath(head, root.right);

    }
    // boolean bfs(TreeNode )
    boolean helper(TreeNode curTN, ListNode curLN){
        if (curTN == null) return false;

        if (curLN == null) return true;

        boolean b = false;

        if (curTN.left != null && curTN.left.val == curLN.val ){
            b = b || helper(curTN.left, curLN.next);
        }
        if (curTN.right != null && curTN.right.val == curLN.val ){
            b = b || helper(curTN.right, curLN.next);
        }

        return b;
        
      
    }
}