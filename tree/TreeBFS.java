package tree;

import java.util.*;

public class TreeBFS {
    public static void main(String args[]) {
        Node root = buildTree(new ArrayList<>(Arrays.asList(0,1,2,3,4,5)), 0);
        List<Node> resultList = new ArrayList<>();
        findTreeBFS(root, new LinkedList<>(), resultList);
        System.out.println(resultList);
    }
    public static void findTreeBFS(Node root, Queue<Node> queue, List<Node> resultList) {
        if(root==null)
            return;
        queue.add(root);
        while(!queue.isEmpty()) {
            Node poppedNode = queue.poll();
            resultList.add(poppedNode);
            if(poppedNode.left != null)
                queue.add(poppedNode.left);
            if(poppedNode.right != null)
                queue.add(poppedNode.right);
        }
    }
    public static Node buildTree(List<Integer> inputList, int i) {
        if(i>= inputList.size())
            return null;
        Node head = new Node(i);
        head.left = buildTree(inputList, 2*i +1);
        head.right = buildTree(inputList, 2*i +2);
        return head;
    }
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
