package tree;

public class MaxDepthOfBinaryTree {
    public static void main(String args[]) {
        TreeNode root2 = new TreeNode(9);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);
        TreeNode root3 = new TreeNode(20, root4, root5);
        TreeNode root1 = new TreeNode(3, root2, root3);
        System.out.println(maxDepth(root1));
    }
    public static int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        return Math.max(left, right);
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
