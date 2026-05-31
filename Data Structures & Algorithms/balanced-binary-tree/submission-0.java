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
    public static class Pair{
        int height;
        boolean isBalanced;

        public Pair(int height,boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }


    public boolean isBalanced(TreeNode root) {
        Pair res = helper(root);
        return res.isBalanced;
    }

    private Pair helper(TreeNode root){
        if(root==null){
            return new Pair(0,true);
        }

        Pair leftRes = helper(root.left);
        Pair rightRes = helper(root.right);

        if(leftRes.isBalanced && rightRes.isBalanced){
            boolean isBalanced = (Math.abs(leftRes.height-rightRes.height)<=1);
            int height = Math.max(leftRes.height,rightRes.height)+1;
            return new Pair(height,isBalanced);
        }

        return new Pair(0,false);
    }
}
