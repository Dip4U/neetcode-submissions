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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue <TreeNode> nodes=new LinkedList<>();
        nodes.add(root);
         if(root==null)
            return result;
        while(!nodes.isEmpty())
        {

           
                int queueLength=nodes.size();

                List<Integer> rs=new ArrayList<>();
                for(int i=0;i<queueLength;i++)
                {
                    TreeNode current=nodes.poll();
                    rs.add(current.val);
                    if(current.left!=null)
                        nodes.add(current.left);
                    if(current.right!=null)
                        nodes.add(current.right);
                }
                result.add(rs);
        }
        return result;
    }
}
