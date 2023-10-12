package linkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        oddEvenList(node1);
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while(right!=null && right.next!=null) {
            ListNode tempLeft = left.next;
            ListNode tempRight = right.next.next;
            left.next = right.next;
            left.next.next = tempLeft;
            right.next = tempRight;
            left = left.next;
            right = right.next;
        }
        return head;
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
