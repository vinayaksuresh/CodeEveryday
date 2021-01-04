/**
 * Reference: https://leetcode.com/problems/find-duplicate-subtrees/
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
    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> subsetTreeMap = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getSubTreeMap(root);
        return ans;
    }
    
    public String getSubTreeMap(TreeNode node){
        if(Objects.isNull(node)) {
            return "";
        }
        String key = getSubTreeMap(node.left) + "," + getSubTreeMap(node.right) + "," + node.val;
        subsetTreeMap.put(key, subsetTreeMap.getOrDefault(key, 0) + 1);
        if (subsetTreeMap.get(key) == 2) {
            ans.add(node);
        }
        return key;
    }
}