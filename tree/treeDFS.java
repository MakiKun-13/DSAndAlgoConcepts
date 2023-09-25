package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class treeDFS {
    public static void main(String args[]) {
        Node root = buildTree(new ArrayList<>(Arrays.asList(0,1,2,3,4,5)), 0);
        List<Integer> resultList = new ArrayList<>();
        findTreeDFS(root, resultList);
        System.out.println(resultList);
    }

    public static void findTreeDFS(Node root, List<Integer> resultList) {
        if(root!=null) {
            resultList.add(root.value);
            findTreeDFS(root.left, resultList);
            findTreeDFS(root.right, resultList);
        }
        return;
    }

    private static Node buildTree(List<Integer> input, int index) {
        if(index>=input.size()) {
            return null;
        }
        Node head = new Node(input.get(index));
        head.left = buildTree(input, 2*index+1);
        head.right = buildTree(input, 2*index+2);
        return head;
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
