package tree;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        isValidBST(null);
    }
    public static boolean isValidBST(TreeNode root) {
        return findIsValidBST(root, null, null);
    }
    public static boolean findIsValidBST(TreeNode root, Integer leftMax, Integer rightMin) {
        if(root==null)
            return true;
        if(rightMin!=null && rightMin>=root.val)
            return false;
        if(leftMax!=null && leftMax<=root.val)
            return false;
        return (findIsValidBST(root.left, root.val, rightMin) && findIsValidBST(root.right, leftMax, root.val));
    }
    public class TreeNode {
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
