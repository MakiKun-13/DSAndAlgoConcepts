package tree;

public class LongestZigzagPathInBinaryTree {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(1);
        TreeNode node8 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1, null, node8);
        TreeNode node5 = new TreeNode(1, null, node7);
        TreeNode node6 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1, node5, node6);
        TreeNode node2 = new TreeNode(1, node3, node4);
        TreeNode node1 = new TreeNode(1, null, node2);
        System.out.println(longestZigZag(node1));
    }
    public static int longestZigZag(TreeNode root) {
        return Math.max(dfs(root, 1, 0),
                dfs(root, 0, 0))-1;
    }
    public static int dfs(TreeNode root, int direction, int currLen) {
        if(root == null) {
            return currLen;
        }
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(direction == 1) {
            left = Math.max(dfs(root.left, 0, currLen+1),
                    dfs(root.right, 1, 1));
        }
        else {
            right = Math.max(dfs(root.right, 1, currLen+1),
                    dfs(root.left, 0, 1));
        }
        return Math.max(left, right);
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
