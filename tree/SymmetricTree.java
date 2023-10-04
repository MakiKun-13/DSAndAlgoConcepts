package tree;

public class SymmetricTree {
    public static void main(String args[]) {
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(4);
        TreeNode root2 = new TreeNode(2, root4, root5);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(3);
        TreeNode root3 = new TreeNode(2, root6, root7);
        TreeNode root1 = new TreeNode(1, root2, root3);
        System.out.println(isSymmetric(root1));
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return true;
        return findSymmetricTree(root.left, root.right);
    }
    public static boolean findSymmetricTree(TreeNode root1, TreeNode root2) {
        if(root1==null && root2!=null)
            return false;
        if(root2==null && root1!=null)
            return false;
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1.val == root2.val) {
            boolean left = findSymmetricTree(root1.left, root2.right);
            boolean right = findSymmetricTree(root1.right, root2.left);
            return left && right;
        }
        else {
            return false;
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
