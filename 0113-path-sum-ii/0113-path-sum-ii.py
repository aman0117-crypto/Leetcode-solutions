# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        Q=[(root,targetSum,[])]
        res=[]
        while Q:
            node,rem_sum,path=Q.pop(0)
            rem_sum=rem_sum-node.val
            path.append(node.val)
            if not node.left and not node.right and rem_sum==0:
                res.append(path)
            if node.left:
                Q.append((node.left,rem_sum,path[:]))
            if node.right:
                Q.append((node.right,rem_sum,path[:]))
        return res


        