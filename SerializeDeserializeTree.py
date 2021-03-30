# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    delimiter = "."
    def bfs_serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        res = ""
        if root.left:
            res = res + self.delimiter + str(root.left.val)
        if root.right:
            res = res + self.delimiter + str(root.right.val)
        if root.left:
            res = res + self.delimiter + self.bfs_serialize(root.left)
        if root.right:
            res = res + self.delimiter + self.bfs_serialize(root.right)
        print (res)
        return res

    def serialize(self, root):
        """Encodes a tree to a single string.
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ""
        return str(root.val) + self.bfs_serialize(root)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode
        """
        nodes = data.split(self.delimiter)
        nodes = [int(node) if len(node) else None for node in nodes]
        pointer = len(nodes) - 1
        while pointer >= 0:
            if nodes[pointer]:
                break
            nodes.pop()
            pointer -= 1
        return nodes
                
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))