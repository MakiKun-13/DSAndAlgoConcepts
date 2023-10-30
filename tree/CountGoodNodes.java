package tree;

public class CountGoodNodes {
    static int count;
    public static int goodNodes(TreeNode root) {
        count = 0;
        findGoodNodes(root, root.val);
        return count;
    }
    public static void findGoodNodes(TreeNode treeNode, int currMax) {
        if(treeNode.val >= currMax) {
            currMax = treeNode.val;
            count++;
        }
        if(treeNode.left != null) {
            findGoodNodes(treeNode.left, currMax);
        }
        if(treeNode.right != null) {
            findGoodNodes(treeNode.right, currMax);
        }
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
