# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        a = []
        def dfsp(list, root) :
            if root is None :
                return
            list.append(root.val)
            dfsp(list, root.left)
            dfsp(list, root.right)
        dfsp(a, root)
        return a