/**
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      sum(root);
      return max;
    }

    public int sum(TreeNode root){
        if(root==null){
            return 0;
        }

        int rootVal = root.val;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int temp = Math.max(Math.max(rootVal,rootVal+leftSum+rightSum)
        ,Math.max(rootVal+leftSum,rootVal+rightSum));
        max = Math.max(max,temp);
        return Math.max(rootVal,Math.max(rootVal+leftSum,rootVal+rightSum));
    }

}
