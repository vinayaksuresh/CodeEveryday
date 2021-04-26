# Definition for a binary tree node.
# Build the binary tree with Preorder and Inorder traverssal.
# Question: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    preorder = None

    def get_root(self, nodes):
        for each in self.preorder:
            try:
                index = nodes.index(each)
                return index, each
            except Exception:
                continue

    def treeify(self, nodes):
        root_index, root_value = self.get_root(nodes)
        root = TreeNode(root_value)

        left_tree = nodes[:root_index]
        right_tree = nodes[root_index+1:]

        if len(left_tree) > 0:
            root.left = self.treeify(left_tree)

        if len(right_tree) > 0:
            root.right = self.treeify(right_tree)

        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0 or preorder[0] == -1:
            return TreeNode(val=-1)

        self.preorder = preorder
        return self.treeify(inorder)
