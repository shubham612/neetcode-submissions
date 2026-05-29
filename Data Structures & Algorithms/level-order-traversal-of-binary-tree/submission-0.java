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
    private static class NodeVsLevel{
        TreeNode node;
        int level;

        public NodeVsLevel(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<NodeVsLevel> queue = new LinkedList<>();
        queue.offer(new NodeVsLevel(root,0));

        while(!queue.isEmpty()){
            NodeVsLevel nodeVsLevel = queue.poll();
            int level = nodeVsLevel.level;
            if(res==null || res.size()<level+1){
                List<Integer> list = new ArrayList<>();
                list.add(nodeVsLevel.node.val);
                res.add(level,list);
            }else{
                List<Integer> currentList = res.get(level);
                currentList.add(nodeVsLevel.node.val);
            }

            if(nodeVsLevel.node.left!=null){
                queue.offer(new NodeVsLevel(nodeVsLevel.node.left,level+1));
            }

             if(nodeVsLevel.node.right!=null){
                queue.offer(new NodeVsLevel(nodeVsLevel.node.right,level+1));
            }
        }

        return res;

    }
}
