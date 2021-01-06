# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.get_depth(root)

    def get_depth(self, node):
        return max(self.get_depth(node.left), self.get_depth(node.right)) + 1 if node else 0
