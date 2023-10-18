package tree;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        maxPathSum(node);
    }
    static int maxPathSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null)
            return root.val;
        findMaxPathSum(root);
        return maxPathSum;
    }
    public static int findMaxPathSum(TreeNode currNode) {
        if(currNode==null) {
            return 0;
        }
        int left = findMaxPathSum(currNode.left);
        int right = findMaxPathSum(currNode.right);
        int total = left + right + currNode.val;
        int maxSumToSendToParent = Math.max(currNode.val , Math.max(left + currNode.val, right + currNode.val));
        int currNodeMaxSum = Math.max(maxSumToSendToParent, total);
        maxPathSum = Math.max(maxPathSum, currNodeMaxSum);
        return maxSumToSendToParent;
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