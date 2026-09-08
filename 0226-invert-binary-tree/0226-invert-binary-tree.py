# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def invertTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: Optional[TreeNode]
        """
        def f(node):
            if not node:
                return 
            left=f(node.left)
            right=f(node.right)
            node.left,node.right=node.right,node.left
        f(root)
        return root
        