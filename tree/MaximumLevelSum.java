package tree;

import java.util.*;

public class MaximumLevelSum {
    public static void main(String args[]) {
        TreeNode root4 = new TreeNode(7);
        TreeNode root5 = new TreeNode(-8);
        TreeNode root2 = new TreeNode(7, root4, root5);
        TreeNode root6 = new TreeNode(-4);
        TreeNode root3 = new TreeNode(0, root6, null);
        TreeNode root1 = new TreeNode(1, root2, root3);
        System.out.println(maxLevelSum(root1));
    }
    public static int maxLevelSum(TreeNode root) {
        if(root==null) {
            return 0;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int maxSum = Integer.MIN_VALUE;
        int minLevel = 1;
        int level = 1;
        while(!bfsQueue.isEmpty()) {
            int currSize = bfsQueue.size();
            int sum = 0;
            for(int i=0; i<currSize; i++) {
                TreeNode node = bfsQueue.poll();
                sum = sum + node.val;
                if(node.left!=null) {
                    bfsQueue.add(node.left);
                }
                if(node.right!=null) {
                    bfsQueue.add(node.right);
                }
            }
            if(sum>maxSum) {
                maxSum = sum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
