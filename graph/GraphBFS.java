package graph;

import java.util.*;

public class GraphBFS {
    public static void main(String[] args) {
        Node root = createGraph();
        List<Node> resultList = new ArrayList<>();
        findGraphBFS(root, resultList, new LinkedList<>(), new HashSet<>());
        System.out.println(resultList);
    }

    private static void findGraphBFS(Node root, List<Node> resultList, Queue<Node> bfsQueue, Set<Node> visitedSet) {
        if (root == null)
            return;
        if (visitedSet.contains(root))
            return;
        bfsQueue.add(root);
        resultList.add(root);
        visitedSet.add(root);
        while (!bfsQueue.isEmpty()) {
            Node poppedNode = bfsQueue.poll();
            for (Node connectedNode : poppedNode.neighbors) {
                if(!visitedSet.contains(connectedNode)) {
                    bfsQueue.add(connectedNode);
                    resultList.add(connectedNode);
                    visitedSet.add(connectedNode);
                }
            }
        }
    }

    public static Node createGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        List<Node> list1 = new ArrayList<>(Arrays.asList(node2, node3, node4));
        node1.addNeighbors(list1);
        List<Node> list2 = new ArrayList<>(Arrays.asList(node5));
        node2.addNeighbors(list2);
        List<Node> list3 = new ArrayList<>(Arrays.asList(node6));
        node3.addNeighbors(list3);
        List<Node> list4 = new ArrayList<>(Arrays.asList(node6));
        node4.addNeighbors(list4);
        List<Node> list5 = new ArrayList<>(Arrays.asList(node7));
        node5.addNeighbors(list5);
        List<Node> list6 = new ArrayList<>(Arrays.asList(node7));
        node6.addNeighbors(list6);
        List<Node> list7 = new ArrayList<>(Arrays.asList(node2, node1));
        node7.addNeighbors(list7);
        return node1;
    }

    public static class Node {
        int data;
        List<Node> neighbors;

        public Node(int data) {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }

        public Node(int data, List<Node> neighbors) {
            this.data = data;
            this.neighbors = neighbors;
        }

        public void addNeighbor(Node neighbor) {
            neighbors.add(neighbor);
        }

        public void addNeighbors(List<Node> list) {
            this.neighbors.addAll(list);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
