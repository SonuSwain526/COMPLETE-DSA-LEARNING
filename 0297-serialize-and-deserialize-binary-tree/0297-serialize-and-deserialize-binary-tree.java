/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder sb;
    TreeNode node;
    int ix;

    public Codec(){
        sb = new StringBuilder();
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {sb.append("x|"); return sb.toString();}

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val + "|");
        while (!q.isEmpty()){
            int s = q.size();

            for (int i = 0; i < s; i++){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                    sb.append(q.peek().left.val + "|");
                }else{
                    sb.append("x|");
                }
                
                if(q.peek().right != null){
                    q.add(q.peek().right);
                    sb.append(q.peek().right.val + "|");
                }else{
                    sb.append("x|");
                }
                q.poll();
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("\\|");
        if (arr[0].equals("x")) return null;
        System.out.println(Arrays.toString(arr));
        node = new TreeNode(Integer.parseInt(arr[0]));
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        int i = 1;
        while (!q.isEmpty()){
            
            TreeNode cur = q.peek();
            if (i < arr.length &&!arr[i].equals("x")){
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(cur.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("x") ){
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(cur.right);
            }
            i++;
            q.poll();
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));