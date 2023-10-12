package tree;

import java.util.*;

public class ZigZagTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, node4, node5);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1, node2, node3);
        System.out.println(zigZagTraversal(root));
    }

    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
        if(root==null) {
            return new ArrayList<>();
        }
        Queue<BinaryTreeNode<Integer>> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        boolean leftToRight = true;
        List<List<Integer>> levelList = new ArrayList<>();

        while(!bfsQueue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = bfsQueue.size();
            for(int i=0; i<size; i++) {
                BinaryTreeNode<Integer> poppedNode = bfsQueue.poll();
                temp.add(poppedNode.data);
                if(poppedNode.left!=null) {
                    bfsQueue.add(poppedNode.left);
                }
                if(poppedNode.right!=null) {
                    bfsQueue.add(poppedNode.right);
                }
            }

            if(!leftToRight)
                Collections.reverse(temp);

            levelList.add(temp);
            leftToRight = !leftToRight;
        }
        List<Integer> resultList = new ArrayList<>();
        for(List<Integer> list : levelList) {
            resultList.addAll(list);
        }
        return resultList;
    }
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
        public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
