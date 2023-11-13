package tree;

public class DeleteNodeInABinarySearchTree {
    public static void main(String[] args) {
        deleteNode(null, 0);
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(root.val==key) {
            return deleteGivenNode(root);
        }
        return findNode(root, key);
    }
    // Searching for the key
    public static TreeNode findNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val==key) {
            return deleteGivenNode(root);
        }
        if(key<root.val)
            root.left = findNode(root.left, key);
        if(key>root.val)
            root.right = findNode(root.right, key);
        return root;
    }
    // Deleting the Node
    public static TreeNode deleteGivenNode(TreeNode root) {
        if(root.left==null && root.right==null)
        {
            return null;
        }
        else if(root.left==null) {
            return root.right;
        }
        else if(root.right==null) {
            return root.left;
        }
        else {
            //Both children are present
            TreeNode temp = root.right;
            TreeNode lastRight = findLastRight(root.left);
            root = root.left;
            if(lastRight!=null)
                lastRight.right = temp;
            else
                root.right = temp;
            return root;
        }
    }
    public static TreeNode findLastRight(TreeNode node) {
        if(node==null || node.right==null)
            return node;
        return findLastRight(node.right);
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
