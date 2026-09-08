# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def hasPathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: bool
        """
        if not root:
            return False
        Stack=[(root,targetSum-root.val)]
        while Stack:
            node,rem_sum=Stack.pop()
            if not node.left and not node.right and rem_sum==0:
                return True
            if node.right:
                Stack.append((node.right,rem_sum-node.right.val))
            if node.left:
                Stack.append((node.left,rem_sum-node.left.val))
        return False
        