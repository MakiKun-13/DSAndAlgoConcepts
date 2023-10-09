package tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String args[]) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, node2, node3);

        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(2);
        TreeNode node11 = new TreeNode(1, node12, node13);

        System.out.println(leafSimilar(node1, node11));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodes1 = new ArrayList<>();
        List<Integer> leafNodes2 = new ArrayList<>();
        dfs(root1, leafNodes1);
        dfs(root2, leafNodes2);
        if (leafNodes1.size() != leafNodes2.size())
            return false;
        for (int i = 0; i < leafNodes1.size(); i++) {
            if (leafNodes1.get(i) != leafNodes2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(TreeNode root, List<Integer> leafNodes) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            leafNodes.add(root.val);
        }
        dfs(root.left, leafNodes);
        dfs(root.right, leafNodes);

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