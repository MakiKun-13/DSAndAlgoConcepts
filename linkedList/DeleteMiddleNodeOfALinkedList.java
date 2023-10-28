package linkedList;

public class DeleteMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        deleteMiddle(null);
    }
    public static ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) {
            return null;
        }
        ListNode prev = new ListNode(0, head);
        ListNode slow = prev;
        ListNode fast = head.next;
        boolean isEven=true;
        while(fast!=null) {
            if(isEven) {
                slow = slow.next;
                isEven = false;
            }
            else {
                isEven = true;
            }
            fast = fast.next;
        }
        slow.next = slow.next.next;
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
/**
 * Solved with slow and fast pointers
 * Time Complexity: O(n)
 * SPace Complexity: O(1)
 */