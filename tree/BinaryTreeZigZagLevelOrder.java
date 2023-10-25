package tree;


import java.util.*;

public class BinaryTreeZigZagLevelOrder {
    public static void main(String args[]) {
        zigzagLevelOrder(null);
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        boolean leftToRight = true;
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        resultList.add(new ArrayList<>(List.of(root.val)));
        while(!bfsQueue.isEmpty()) {
            List<Integer> elementsOfLevel = new ArrayList<>();
            int size = bfsQueue.size();
            for(int i=0; i<size; i++) {
                TreeNode polledNode = bfsQueue.poll();
                if(polledNode.left != null)
                {
                    bfsQueue.add(polledNode.left);
                    elementsOfLevel.add(polledNode.left.val);
                }
                if(polledNode.right != null)
                {
                    bfsQueue.add(polledNode.right);
                    elementsOfLevel.add(polledNode.right.val);
                }
            }
            if(leftToRight) {
                Collections.reverse(elementsOfLevel);
            }
            leftToRight = !leftToRight;
            resultList.add(elementsOfLevel);
        }
        resultList.remove(resultList.size()-1);
        return resultList;
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
