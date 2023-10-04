package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String args[]) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, null, node4);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(rightSideView(node1));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelOfNodes = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();
        int level = 0;
        queue.add(root);
        levelOfNodes.add(level);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level = levelOfNodes.poll();
            if(null != node.left) {
                queue.add(node.left);
                levelOfNodes.add(level+1);
            }
            if(null != node.right) {
                queue.add(node.right);
                levelOfNodes.add(level+1);
            }
            resultList.add(level, node.val);
        }
        return resultList.subList(0, level+1);
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
