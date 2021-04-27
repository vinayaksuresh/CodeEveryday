# Check Array Formation Through Concatenation
# You are given an array of distinct integers arr and an array of integer arrays pieces, 
# where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. 
# However, you are not allowed to reorder the integers in each array pieces[i].
# Return true if it is possible to form the array arr from pieces. Otherwise, return false.
# Question: https://leetcode.com/problems/check-array-formation-through-concatenation/

# Question: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class Solution:
    def canFormArray(self, arr: List[int], pieces: List[List[int]]) -> bool:
       helper_dict = { each[0]: each for each in pieces }
       
       temp_array = []
       i = 0
       while i < len(arr):
            each = arr[i]
            temp = helper_dict.get(each)
            if not temp:
                return False
            i += len(temp)
            temp_array = temp_array + temp
       
       if len(temp_array) != len(arr):
            return False
        
       for temp, each in zip(temp_array, arr):
            if temp != each:
                return False
            
       return True
       