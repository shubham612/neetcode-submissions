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

    public class Pair{
        int  depth;
        int  diameter;

        public Pair(int depth,int diamter){
            this.depth = depth;
            this.diameter = diamter;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair res = helper(root);
        return res.diameter;  
    }

    public Pair helper(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }

        if(root.left==null && root.right==null){
            return new Pair(1,0);
        }

        Pair leftRes = new Pair(0,0);
        Pair rightRes = new Pair(0,0);

        if(root.left!=null){
           leftRes = helper(root.left);
        }

        if(root.right!=null){
           rightRes = helper(root.right);
        }

        int diameter = Math.max((leftRes.depth+rightRes.depth),
        Math.max(leftRes.diameter,rightRes.diameter));

        int depth = Math.max(leftRes.depth,rightRes.depth)+1;

        return new Pair(depth,diameter);
    }
}
