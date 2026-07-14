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

    Stack<TreeNode> leftStack = new Stack<>();
    Stack<TreeNode> rightStack = new Stack<>();

    public boolean findTarget(TreeNode root, int k) {

        pushLeft(root);
        pushRight(root);

        int left = nextLeft();
        int right = nextRight();

        while (left < right) {

            int sum = left + right;

            if (sum == k)
                return true;

            if (sum < k) {
                left = nextLeft();
            } else {
                right = nextRight();
            }
        }

        return false;
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            leftStack.push(node);
            node = node.left;
        }
    }

    private void pushRight(TreeNode node) {
        while (node != null) {
            rightStack.push(node);
            node = node.right;
        }
    }

    private int nextLeft() {
        TreeNode node = leftStack.pop();
        pushLeft(node.right);
        return node.val;
    }

    private int nextRight() {
        TreeNode node = rightStack.pop();
        pushRight(node.left);
        return node.val;
    }
}