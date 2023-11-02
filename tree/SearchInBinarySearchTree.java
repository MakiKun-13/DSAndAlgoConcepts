package tree;

public class SearchInBinarySearchTree {
    public static TreeNode searchBST(TreeNode root, int val) {
        while(root!=null) {
            if(root.val==val) {
                return root;
            }
            if(root.val<val) {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return null;
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
